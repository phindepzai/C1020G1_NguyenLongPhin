import { studentList } from './../model/list';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {
  list = studentList;
  constructor() { }

  ngOnInit(): void {
  }
}
