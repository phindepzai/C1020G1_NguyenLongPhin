import { IStudent } from './../model/Student';
import { studentList } from './../model/list';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})

export class StudentListComponent implements OnInit {
  student: IStudent;
  index = -2;
  formControlClass = 'form-control ';
  isValidClass = 'is-valid';
  isInvalidClass = 'is-invalid';
  contactForm: FormGroup;

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
    this.student = this.list.find(e => e.id === 1);
    this.contactForm = this.getFormGroup();
  }

  getFormGroup() {
    return new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required, Validators.pattern('^([A-Z][a-z]+[ ])+[A-Z][a-z]+$')]),
      age: new FormControl('', [Validators.required, Validators.min(18), Validators.max(100)]),
      mark: new FormControl('', [Validators.required, Validators.min(0), Validators.max(10)]),
      avatar: new FormControl('', [Validators.required])
    });
  }

  modalDetail(student: IStudent, content) {
    this.student = student;
    this.contactForm = this.getFormGroup();
    this.contactForm.setValue(student);
    this.modalService.open(content, { windowClass: 'dark-modal', size: 'lg' });
  }

  getClass(propertyName: string) {
    if (this.contactForm.get(propertyName).dirty ||
      (this.contactForm.get(propertyName).touched && this.contactForm.get(propertyName).invalid)) {
      return this.contactForm.get(propertyName).valid ? this.isValidClass : this.isInvalidClass;
    } else {
      return '';
    }
  }

  submitForm(e) {
    if (!this.contactForm.valid) {
      e.preventDefault();
    } else {
      this.student = this.contactForm.getRawValue();
      this.saveStudent();
    }
  }

  saveStudent() {
    if (this.index === -1) {
      this.list.push(this.student);
    } else {
      this.list.splice(this.index, 1, this.student);
    }
  }

  setIndex(id) {
    this.index = this.list.indexOf(this.student);
  }

  studentN() {
    this.index = -1;
    const studentN = {
      id: this.list.length + 1,
      name: '',
      age: 0,
      mark: 0,
      avatar: ''
    };
    return studentN as IStudent;
  }

  delete() {
    const index = this.list.indexOf(this.student);
    studentList.splice(index, 1);
  }

  get list() {
    return studentList;
  }

  get name() {
    return this.contactForm.get('name');
  }

  get age() {
    return this.contactForm.get('age');
  }

  get mark() {
    return this.contactForm.get('mark');
  }

  get avatar() {
    return this.contactForm.get('avatar');
  }
}
