import { StudentInformationComponent } from './student-information/student-information.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HackernewsComponent } from './james/thuchanh/hackernews/hackernews.component';
import { StudentListComponent } from './student-list/student-list.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    StudentInformationComponent,
    HackernewsComponent,
    StudentListComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    [RouterModule.forRoot([
      { path: '', redirectTo: 'student-list', pathMatch: 'full' },
      { path: 'student-information/:id', component: StudentInformationComponent },
      { path: 'student-list', component: StudentListComponent }
    ])]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
