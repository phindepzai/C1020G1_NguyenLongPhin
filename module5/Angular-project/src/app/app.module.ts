import { StudentInformationComponent } from './student-information/student-information.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentInformationComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    [RouterModule.forRoot([
      { path: 'student-information', component: StudentInformationComponent }
    ])]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
