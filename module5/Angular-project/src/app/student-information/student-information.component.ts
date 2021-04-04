import { StudentServiceService } from './../service/student-service.service';
import { IStudent } from './../model/Student';
import { studentList } from './../model/list';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter, tap } from 'rxjs/operators';

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.scss']
})

export class StudentInformationComponent implements OnInit {
  student: IStudent = {
    id: 0,
    name: '',
    age: 0,
    mark: 0,
    avatar: ''
  };
  constructor(private route: ActivatedRoute, private studentService: StudentServiceService, private router: Router) { }

  ngOnInit(): void {
    let id;
    this.route.paramMap.subscribe(param => id = param.get('id'));
    this.studentService.view(id).subscribe(data => this.student = data[0]);
    setTimeout(() => {
      console.log(this.student);
      if (this.student === undefined) {
        this.router.navigate(['']);
      }
    }, 100);
  }

  isNav() {
    if (this.student === undefined) {
      this.router.navigate(['']);
    }
  }

  changeMark(value) {
    this.student.mark = value;
  }
}
