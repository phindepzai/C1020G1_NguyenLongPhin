import { studentList } from './../model/list';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.scss']
})

export class StudentInformationComponent implements OnInit {
  student = null;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.setStudent(this.route.snapshot.paramMap.get('id'));
  }

  setStudent(id){
    this.student = studentList.find(element => element.id === Number.parseFloat(id));
  }

  changeMark(value) {
    this.student.mark = value;
  }
}
