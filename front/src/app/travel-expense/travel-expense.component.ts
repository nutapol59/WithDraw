import { Component, OnInit, Input,Directive } from '@angular/core';
import { Location } from '@angular/common';
import { Router } from '@angular/router'


import { TravelExpense } from './travel-expense'
import { AppUser } from '../app-user/app-user';
import { Company } from '../company/company';
import { Department } from '../department/department';
import { Customer } from '../customer/customer';


import { TravelExpenseDetailComponent } from '../travel-expense-detail/travel-expense-detail.component';
import { TravelExpenseService } from '../travel-expense/travel-expense.service'
import { AppUserService } from '../app-user/app-user.service';
import{ CustomerService } from '../customer/customer.service';



@Component({
  selector: 'app-travel-expense',
  templateUrl: './travel-expense.component.html',
  styleUrls: ['./travel-expense.component.css']
  
})
export class TravelExpenseComponent implements OnInit {
  
  travelExpenses:TravelExpense[];
  travelExpense = new TravelExpense();
  customers:Customer[];
  customer = new Customer();
  appUser = new AppUser();
  company = new Company();
  department = new Department();

  
  

  isResultTable : boolean = false;

  constructor(private travelExpenseService:TravelExpenseService,
              private appUserService:AppUserService, private customerService:CustomerService,
              private router: Router) {
              
               }

  

  ngOnInit() {
    this.getAppUserById();
    setTimeout(() => {
       this.company = this.appUser.company;
       this.department = this.appUser.department;
    },1000);
  }


  showResultTable(){
    this.isResultTable = true;  
  }

  gotoListSentApprove(){
    console.log(this.appUser.id);
    this.router.navigate(['/listSentApprove', this.appUser.id]);
  }

  getTravelExpenses(){
    this.travelExpenseService.getTravelExpenses()
            .subscribe(
                (data) => this.travelExpenses = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.travelExpenses))
            )
  }

  getAppUserById(){
    this.appUserService.getAppUserById(2)
      .subscribe(
                data => this.appUser = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.appUser))
            )
    
  }

    getCustomers(){
    this.customerService.getCustomers()
      .subscribe(
        data => this.customers = data,
        error => console.log(error),
        () => console.log(JSON.stringify(this.customers))
      )
    
  }


  addTravelExpense(){
    this.travelExpenseService.addTravelExpense(this.appUser.id,this.company.id,this.department.id,this.travelExpense.comment)
                            .subscribe(
                              data => this.travelExpense.id = data,
                              error => console.log(error),
                              ()=> {console.log("Add Success"),
                                    this.showResultTable(),
                                  console.log(this.travelExpense.id)}
                            )
    
  }

  onClearUpdate(comment:HTMLInputElement){
    comment.value = this.travelExpense.comment;
  }

  updateTravelExpense(comment:HTMLInputElement){
    this.travelExpense.comment = comment.value;
    console.log("Update TravelExpense: "+ this.travelExpense.id);
    this.travelExpenseService.updateTravelExpense(this.travelExpense.id,this.travelExpense.comment)
                             .subscribe(
                               data => this.travelExpense.id = data,
                               error => alert(error),
                               () => {
                                 console.log("Update Success"),
                                 console.log(this.travelExpense.id)}
                               
                             )
  }

}
