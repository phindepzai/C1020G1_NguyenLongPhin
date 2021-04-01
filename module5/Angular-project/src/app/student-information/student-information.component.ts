import { IStudent } from './../model/Student';
import { studentList } from './../model/list';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.scss']
})

export class StudentInformationComponent implements OnInit {
  @Input()
  student: IStudent;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  setStudent(id){
    this.student = studentList.find(element => element.id === Number.parseFloat(id));
  }

  changeMark(value) {
    this.student.mark = value;
  }
}
