import { Component, OnInit,Input } from '@angular/core';

import { Customer } from '../customer/customer';
import { TravelExpenseDetail } from '../travel-expense-detail/travel-expense-detail';

import{ CustomerService } from '../customer/customer.service';
import { TravelExpenseService } from '../travel-expense/travel-expense.service';
import { TravelExpenseDetailService } from '../travel-expense-detail/travel-expense-detail.service'

@Component({
  selector: 'app-travel-expense-detail',
  templateUrl: './travel-expense-detail.component.html',
  styleUrls: ['./travel-expense-detail.component.css']
})
export class TravelExpenseDetailComponent implements OnInit {
  travelExpenseDetails:TravelExpenseDetail[];
  travelExpenseDetail = new TravelExpenseDetail();

  @Input('customers')
  customers:Customer[];

  @Input('travelExpenseId')
  travelExpenseId:number
  
  customer = new Customer();


  constructor(private travelExpenseService:TravelExpenseService,
              private customerService:CustomerService,
              private travelExpenseDetailService:TravelExpenseDetailService) {
       
   }

  ngOnInit() {
    console.log("Detailll: "+this.travelExpenseId);
  }

  validateNegative(event){
      console.log(event.target.value.match(/[^\d]/g));
      if(event.target.value!=null &&  (event.target.value.match(/[^\d]/g)) ){
        event.target.value = "";
      }
  }

addTravelExpenseDetail(){
  this.travelExpenseDetailService.addTravelExpenseDetail(this.travelExpenseDetail,this.travelExpenseId)
    .subscribe(
      data => console.log(JSON.stringify(data)),
      error => console.log(error),
      () => console.log("Add Detail Success")
    )
}
  // getCustomers(){
  //   this.customerService.getCustomers()
  //     .subscribe(
  //       data => this.customers = data,
  //       error => console.log(error),
  //       () => console.log(JSON.stringify(this.customers))
  //     )
    
  // }

}
