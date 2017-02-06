import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CompanyComponent } from './company/company.component';
import { HeaderComponent } from './header/header.component';
import { FormWithDrawComponent } from './form-with-draw/form-with-draw.component';
import { DepartmentComponent } from './department/department.component';

import { CompanyService } from './company/company.service';
import { DepartmentService } from './department/department.service';
import { AppUserService } from './app-user/app-user.service';

import { AppRoutingModule }     from './app-routing.module';

import { AppUserComponent } from './app-user/app-user.component';


@NgModule({
  declarations: [
    AppComponent,
    CompanyComponent,
    HeaderComponent,
    FormWithDrawComponent,
    DepartmentComponent,
    AppUserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [CompanyService,DepartmentService,AppUserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
