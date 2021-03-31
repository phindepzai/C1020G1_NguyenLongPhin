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
  contactForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.required]),
    mark: new FormControl('', [Validators.required]),
    avatar: new FormControl('', [Validators.required])
  });

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
    this.student = this.list.find(e => e.id === 1);
  }

  modalDetail(student: IStudent, content) {
    this.student = student;
    this.modalService.open(content, { windowClass: 'dark-modal', size: 'lg' });
    this.contactForm.setValue(student);
    console.log(student.id);
  }

  submitForm(e){
    if (!this.contactForm.get('name').valid){
      e.preventDefault();
    } else {
      console.log(this.student);
      this.saveStudent();
    }
  }

  saveStudent() {
    if (this.index === -1) {
      this.list.push(this.student);
    } else if (this.index === -2) {
      this.list.splice(this.index, 0, this.student);
    }
    console.log(this.list);
  }

  setIndex(id){
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
}
