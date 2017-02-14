import { Component, OnInit,Input } from '@angular/core';
import { Router } from '@angular/router'

import { Customer } from '../customer/customer';
import { TravelExpenseDetail } from '../travel-expense-detail/travel-expense-detail';

import{ CustomerService } from '../customer/customer.service';
import { TravelExpenseService } from '../travel-expense/travel-expense.service';
import { TravelExpenseDetailService } from '../travel-expense-detail/travel-expense-detail.service'

import {IMyOptions, IMyDateModel} from 'mydatepicker';
import { DatepickerModule as YourAlias } from 'angular2-material-datepicker'

@Component({
  selector: 'app-travel-expense-detail',
  templateUrl: './travel-expense-detail.component.html',
  styleUrls: ['./travel-expense-detail.component.css']
})
export class TravelExpenseDetailComponent implements OnInit {
  travelExpenseDetails:TravelExpenseDetail[];
  travelExpenseDetail = new TravelExpenseDetail();
  travelExpenseDetailUpdate:TravelExpenseDetail;

  @Input('customers')
  customers:Customer[];

  @Input('travelExpenseId')
  travelExpenseId:number

  @Input('appUserId')
  appUserId:number;
  
  customer = new Customer();
  customerIdUpdate:number;

  date:Date;
  dateUpdate:Date;



  constructor(private travelExpenseService:TravelExpenseService,
              private customerService:CustomerService,
              private travelExpenseDetailService:TravelExpenseDetailService,
              private router: Router) {
       
   }

  ngOnInit() {
    console.log("TravelExpenseId in TravelExpenseDetail: "+this.travelExpenseId);
    console.log("AppUserId: "+this.appUserId);
  }



   private myDatePickerOptions: IMyOptions = {
        // other options...
        dateFormat: 'yyyy-mm-dd',

  }

  onDateChanged(event: IMyDateModel) {
      var date = event.date.year+"-"+this.checkDateForm(event.date.month)+"-"+this.checkDateForm(event.date.day);

      this.date = this.stringToDate(date,"yyyy-mm-dd","-");
      //2017-02-01
      //console.log(date.split('-'));
      //["2017","02","01"]
     this.travelExpenseDetail.travelDate =  this.date.getTime();
       console.log("event.date: "+this.travelExpenseDetail.travelDate);
  }

    onDateChangedUpdate(event: IMyDateModel) {
      var date = event.date.year+"-"+this.checkDateForm(event.date.month)+"-"+this.checkDateForm(event.date.day);
      this.dateUpdate = this.stringToDate(date,"yyyy-mm-dd","-");
      this.travelExpenseDetailUpdate.travelDate =  this.dateUpdate.getTime();
       console.log("event.date: "+this.travelExpenseDetailUpdate.travelDate);
  }



  stringToDate(_date,_format,_delimiter){
            var formatLowerCase=_format.toLowerCase();
            var formatItems=formatLowerCase.split(_delimiter);
            var dateItems=_date.split(_delimiter);
            var monthIndex=formatItems.indexOf("mm");
            var dayIndex=formatItems.indexOf("dd");
            var yearIndex=formatItems.indexOf("yyyy");
            var month=parseInt(dateItems[monthIndex]);
            month-=1;
            var formatedDate = new Date(dateItems[yearIndex],month,dateItems[dayIndex]);
            return formatedDate;
}

  checkDateForm(str){
    if(str<10){
      return '0'+str;
    }
    return str;
  }

  

  onClear(){
    

    this.travelExpenseDetail.travelDate = null;
    this.travelExpenseDetail.customer = null;
    this.travelExpenseDetail.travelFrom = "";
    this.travelExpenseDetail.travelTo = "";
    this.travelExpenseDetail.expense = null;
    this.travelExpenseDetail.expWayExpense=null;
    this.travelExpenseDetail.expenseSubSummary=null;
    this.travelExpenseDetail.comment ="";
  }

  detailModalUpdate(travelExpenseDetail){
    console.log(travelExpenseDetail)
    this.travelExpenseDetailUpdate = travelExpenseDetail;
    
  }

  onClearUpdate(travelDate:HTMLInputElement,customer:HTMLInputElement,travelFrom:HTMLInputElement,
                travelTo:HTMLInputElement,expense:HTMLInputElement,expWayExpense:HTMLInputElement
                ,expenseSubSummary:HTMLInputElement,comment:HTMLInputElement){
      travelDate.value = this.travelExpenseDetailUpdate.travelDate.toString();
      customer.value = this.travelExpenseDetailUpdate.customer.toString();
      travelFrom.value = this.travelExpenseDetailUpdate.travelFrom;
      travelTo.value = this.travelExpenseDetailUpdate.travelTo;
      expense.value = this.travelExpenseDetailUpdate.expense.toString();
      expWayExpense.value = this.travelExpenseDetailUpdate.expWayExpense.toString();
      expenseSubSummary.value = this.travelExpenseDetailUpdate.expenseSubSummary.toString();
      comment.value = this.travelExpenseDetailUpdate.comment;

      console.log(this.travelExpenseDetailUpdate);

  }

  validateNegative(event){
      console.log(event.target.value.match(/[^\d]/g));
      if(event.target.value!=null &&  (event.target.value.match(/[^\d]/g)) ){
        event.target.value = "";
      }
  }string

  gotoListSentApprove(){
    console.log(this.appUserId);
    this.router.navigate(['/listSentApprove', this.appUserId]);
  }

  addTravelExpenseDetail(){
    console.log(this.travelExpenseDetail.travelDate);
    console.log(this.date);
    // this.travelExpenseDetail.travelDate = this.date.getTime();
    this.travelExpenseDetailService.addTravelExpenseDetail(this.travelExpenseDetail,this.travelExpenseId,
                                                            this.date.getTime())
      .subscribe(
        data => console.log(JSON.stringify(data)),
        error => console.log(error),
        () => {console.log("Add Detail Success"),
                this.getTravelExpenseDetailsByTravelExpenseId()
                this.onClear(); }
      )
  }

  onSelectboxChange(event){
        console.log("old Id Customer :"+this.travelExpenseDetailUpdate.customer.id);
        
        console.log("new Id Customer : "+event); //id company update in selectBox
        this.customerIdUpdate = event;
        console.log(this.customerIdUpdate);

        //console.log(this.departmentUpdate.company); 
    }

  updateTravelExpenseDetail(travelDate:HTMLInputElement,customer:HTMLInputElement,travelFrom:HTMLInputElement,
                travelTo:HTMLInputElement,expense:HTMLInputElement,expWayExpense:HTMLInputElement
                ,expenseSubSummary:HTMLInputElement,comment:HTMLInputElement){
          console.log("dateUpdate:"+this.dateUpdate);
          console.log("cusUpdate:"+this.customerIdUpdate);
          
          if(this.customerIdUpdate != null){
            this.travelExpenseDetailUpdate.customer.id = this.customerIdUpdate;
          }

          if(this.dateUpdate != null){
            this.travelExpenseDetailUpdate.travelDate = this.dateUpdate.getTime();
          }

          this.travelExpenseDetailUpdate.travelFrom = travelFrom.value;
          this.travelExpenseDetailUpdate.travelTo = travelTo.value;
          this.travelExpenseDetailUpdate.expense = parseInt(expense.value); 
          this.travelExpenseDetailUpdate.expWayExpense = parseInt(expWayExpense.value);
          this.travelExpenseDetailUpdate.expenseSubSummary = parseInt(expenseSubSummary.value);
          this.travelExpenseDetailUpdate.comment = comment.value;

          this.travelExpenseDetailService.updateTravelExpenseDetail(this.travelExpenseDetailUpdate,this.travelExpenseId,
                                                                    this.travelExpenseDetailUpdate.customer.id, this.travelExpenseDetailUpdate.travelDate)
            .subscribe(
              data => console.log(JSON.stringify(data)),
              error => console.log(error),
              () => {console.log("Update Detail Success"),
                      this.getTravelExpenseDetailsByTravelExpenseId() }
            )
          
  }

  deleteTravelExpenseDetail(travelExpenseDetail:TravelExpenseDetail){
    this.travelExpenseDetailService.deleteTravelExpenseDetail(travelExpenseDetail.id)
                                   .subscribe(
                                     data => alert(data),
                                     error => alert(error),
                                     () => {
                                       this.getTravelExpenseDetailsByTravelExpenseId();
                                     }
                                   )
  }

  getTravelExpenseDetails(){
    this.travelExpenseDetailService.getTravelExpenseDetails()
        .subscribe(
          data => {this.travelExpenseDetails = data, console.log(JSON.stringify(data))},
          error => console.log(error),
          () => alert("Get TravelExpenseDetails Success")
        )
  }

  getTravelExpenseDetailsByTravelExpenseId(){
    this.travelExpenseDetailService.getTravelExpenseDetailsByTravelExpenseId(this.travelExpenseId)
        .subscribe(
          data => {this.travelExpenseDetails = data, console.log(JSON.stringify(data))},
          error => console.log(error),
          () => alert("Get TravelExpenseDetails Success")
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
