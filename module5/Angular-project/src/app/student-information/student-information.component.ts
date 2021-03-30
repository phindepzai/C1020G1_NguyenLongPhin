import { Component, OnInit } from '@angular/core';
import { IStudent } from '../model/Student';

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.scss']
})

export class StudentInformationComponent implements OnInit {
  isValid = true;
  formControl = 'form-control is-invalid';
  formControlVsIsValid = 'form-control is-valid';
  student: IStudent = {
    id: 1,
    name: 'tran huu han',
    age: 19,
    mark: 1,
    avatar: 'https://tunglocpet.com/wp-content/uploads/2020/09/cho-husky-su-that-02.jpg'
  };

  constructor() { }

  ngOnInit(): void {
  }

  changeMark(value) {
    this.student.mark = value;
  }

  getClass() {
    return this.isValid ? this.formControlVsIsValid : this.formControl;
  }
}
