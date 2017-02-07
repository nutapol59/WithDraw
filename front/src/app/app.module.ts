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
import { AppUserComponent } from './app-user/app-user.component';
import { BankComponent } from './bank/bank.component';
import { CustomerComponent } from './customer/customer.component';

import { CompanyService } from './company/company.service';
import { DepartmentService } from './department/department.service';
import { AppUserService } from './app-user/app-user.service';
import { BankService } from './bank/bank.service';
import { CustomerService } from './customer/customer.service';

import { AppRoutingModule }     from './app-routing.module';




@NgModule({
  declarations: [
    AppComponent,
    CompanyComponent,
    HeaderComponent,
    FormWithDrawComponent,
    DepartmentComponent,
    AppUserComponent,
    BankComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [CompanyService,DepartmentService,AppUserService,CustomerService,BankService],
  bootstrap: [AppComponent]
})
export class AppModule { }
