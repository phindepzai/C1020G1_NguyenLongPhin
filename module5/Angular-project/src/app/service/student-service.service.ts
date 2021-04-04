import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AbstractControl, FormControl, FormGroup, Validators, Validator, ValidatorFn, ValidationErrors } from '@angular/forms';
import { IStudent } from './../model/Student';
import { Injectable } from '@angular/core';
import { map, filter, tap } from 'rxjs/operators';
import { forkJoin } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class StudentServiceService {
  students: IStudent[];
  form: FormGroup;
  a: IStudent;
  constructor(private http: HttpClient) {
    this.getList();
    this.newForm();
  }

  nameValidator(control: FormControl) {
    let str = control.value;
    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, 'a');
    str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, 'e');
    str = str.replace(/ì|í|ị|ỉ|ĩ/g, 'i');
    str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, 'o');
    str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, 'u');
    str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, 'y');
    str = str.replace(/đ/g, 'd');
    return /^([A-Z][a-z]+[ ])+[A-Z][a-z]+$/.test(str) ? null : { name: control.value };
  }

  save(student) {
    if (student.id == null) {
      this.post(student).subscribe();
    } else {
      this.put(student).subscribe();
    }
  }

  post(student: IStudent) {
    return this.http.post('http://localhost:3000/students/', student);
  }

  put(student: IStudent) {
    return this.http.put('http://localhost:3000/students/' + student.id, student);
  }

  deleteById(id) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json'
      })
    };
    return this.http.delete('http://localhost:3000/students/' + id);
  }

  view(id) {
    return this.http.get<IStudent>('http://localhost:3000/students?id=' + id);
  }

  getList() {
    return this.http.get<IStudent[]>('http://localhost:3000/students');
  }

  newForm() {
    this.form = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required, this.nameValidator]),
      age: new FormControl('', [Validators.required, Validators.min(18), Validators.max(100), Validators.pattern('[0-9]+')]),
      mark: new FormControl('', [Validators.required, Validators.min(0), Validators.max(10), Validators.pattern('[0-9]+')]),
      avatar: new FormControl('', [Validators.required])
    });
  }
}
