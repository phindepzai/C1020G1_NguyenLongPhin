import { Router } from '@angular/router';
import { StudentServiceService } from './../service/student-service.service';
import { IStudent } from './../model/Student';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})

export class StudentListComponent implements OnInit, OnDestroy {
  student: IStudent;
  list: IStudent[];
  subscription: Subscription;
  constructor(private modalService: NgbModal, private router: Router,
              private studentService: StudentServiceService, private httpClient: HttpClient) { }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.setList();
  }

  setList() {
    // this.list = undefined;
    setTimeout(() => console.log(this.list), 200);
    this.subscription = this.studentService.getList().subscribe(list => this.list = list);
  }

  modalDetail(id: number, content) {
    this.studentService.newForm();
    if (id == null) {
      this.student = this.studentN();
    } else {
      this.studentService.view(id).subscribe(data => this.student = data[0]);
    }
    setTimeout(() => {
      this.form.setValue(this.student);
      this.modalService.open(content, { windowClass: 'dark-modal', size: 'lg' });
    }, 100);
  }

  studentN() {
    const studentN = {
      id: null,
      name: '',
      age: 0,
      mark: 0,
      avatar: ''
    };
    return studentN as IStudent;
  }

  delete(id) {
    const a = this.studentService.deleteById(id).subscribe();
    this.setList();
    a.unsubscribe();
  }

  get form() {
    return this.studentService.form;
  }
}
