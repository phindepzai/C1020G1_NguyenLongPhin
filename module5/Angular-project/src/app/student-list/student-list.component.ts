import { IStudent } from './../model/Student';
import { studentList } from './../model/list';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})

export class StudentListComponent implements OnInit {
  student: IStudent;
  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
    this.student = this.list.find(e => e.id === 1);
  }

  modalDetail(student: IStudent, content) {
    this.student = student;
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }

  delete() {
    const index = this.list.indexOf(this.student);
    studentList.splice(index, 1);
  }

  get list() {
    return studentList;
  }
}
