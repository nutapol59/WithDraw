import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

// import { DatePickerModule } from 'ng2-datepicker';
import { MyDatePickerModule } from 'mydatepicker';
import { DatepickerModule } from 'angular2-material-datepicker'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { CompanyComponent } from './company/company.component';
import { HeaderComponent } from './header/header.component';
import { DepartmentComponent } from './department/department.component';
import { AppUserComponent } from './app-user/app-user.component';
import { BankComponent } from './bank/bank.component';
import { CustomerComponent } from './customer/customer.component';
import { TravelExpenseComponent } from './travel-expense/travel-expense.component';
import { TravelExpenseDetailComponent } from './travel-expense-detail/travel-expense-detail.component';

import { CompanyService } from './company/company.service';
import { DepartmentService } from './department/department.service';
import { AppUserService } from './app-user/app-user.service';
import { BankService } from './bank/bank.service';
import { CustomerService } from './customer/customer.service';
import { TravelExpenseService } from './travel-expense/travel-expense.service';
import { TravelExpenseDetailService } from './travel-expense-detail/travel-expense-detail.service';
import { ApproveMapFlowService } from './approve-map-flow/approve-map-flow.service';

import { AppRoutingModule }     from './app-routing.module';
import { DocumentMasterComponent } from './document-master/document-master.component';
import { ListSentApproveComponent } from './list-sent-approve/list-sent-approve.component';
import { ApproveMapFlowComponent } from './approve-map-flow/approve-map-flow.component';


import { ConfigModeServerService } from './config-mode-server.service';





@NgModule({
  declarations: [
    AppComponent,
    CompanyComponent,
    HeaderComponent,
    DepartmentComponent,
    AppUserComponent,
    BankComponent,
    CustomerComponent,
    TravelExpenseComponent,
    TravelExpenseDetailComponent,
    DocumentMasterComponent,
    ListSentApproveComponent,
    ApproveMapFlowComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    DatepickerModule,
    MyDatePickerModule,
    NgbModule
  ],
  providers: [CompanyService,DepartmentService,AppUserService
             ,CustomerService,BankService,TravelExpenseService
             ,TravelExpenseDetailService,ApproveMapFlowService,
             ConfigModeServerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
