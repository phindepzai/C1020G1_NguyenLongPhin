import { StudentServiceService } from './../service/student-service.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-save',
  templateUrl: './student-save.component.html',
  styleUrls: ['./student-save.component.scss']
})
export class StudentSaveComponent implements OnInit {
  formControlClass = 'form-control ';
  isValidClass = 'is-valid';
  isInvalidClass = 'is-invalid';
  @Input()
  modal;
  @Output()
  e = new EventEmitter();
  emit(){
    this.e.emit();
  }
  constructor(private studentService: StudentServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  getClass(propertyName: string) {
    if (this.form.get(propertyName).dirty ||
      (this.form.get(propertyName).touched && this.form.get(propertyName).invalid)) {
      return this.form.get(propertyName).valid ? this.isValidClass : this.isInvalidClass;
    } else {
      return '';
    }
  }

  submitForm(e) {
    if (!this.form.valid) {
      e.preventDefault();
    } else {
      const student = this.form.getRawValue();
      this.studentService.save(student);
      this.emit();
    }
  }

  get name() {
    return this.form.get('name');
  }

  get age() {
    return this.form.get('age');
  }

  get mark() {
    return this.form.get('mark');
  }

  get avatar() {
    return this.form.get('avatar');
  }

  get form() {
    return this.studentService.form;
  }
}
