import { StudentServiceService } from './service/student-service.service';
import { StudentInformationComponent } from './student-information/student-information.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HackernewsComponent } from './james/thuchanh/hackernews/hackernews.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentSaveComponent } from './student-save/student-save.component';
import { HttpClientModule } from '@angular/common/http';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    StudentInformationComponent,
    HackernewsComponent,
    StudentListComponent,
    StudentSaveComponent
  ],
    imports: [
        FormsModule,
        BrowserModule,
        [RouterModule.forRoot([
            {path: '', redirectTo: 'student-list', pathMatch: 'full'},
            {path: 'student-information/:id', component: StudentInformationComponent},
            {path: 'student-list', component: StudentListComponent},
            {path: '**', redirectTo: 'student-list', pathMatch: 'full'}
        ])],
        ReactiveFormsModule,
        HttpClientModule
    ],
  providers: [StudentServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
