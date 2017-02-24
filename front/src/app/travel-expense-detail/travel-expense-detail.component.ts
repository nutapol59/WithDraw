import { Component, OnInit,Input,ViewChild } from '@angular/core';
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
  travelExpenseDetailUpdate = new TravelExpenseDetail();
  expenseResult:number =  0;
  expenseWayResult:number = 0;
  expenseSummary:number = 0;

  @Input('customers')
  customers:Customer[];

  @Input('travelExpenseId')
  travelExpenseId:number

  @Input('appUserId')
  appUserId:number;

  @ViewChild('attachFile1')
  inputFile1: any; 
  @ViewChild('attachFile2')
  inputFile2: any; 
  @ViewChild('attachFile3')
  inputFile3: any; 

  @ViewChild('fileUpdate1')
  inputFileUpdate1: any; 
  @ViewChild('fileUpdate2')
  inputFileUpdate2: any; 
  @ViewChild('fileUpdate3')
  inputFileUpdate3: any; 
  
  

  customer = new Customer();
  customerIdUpdate:number;

  date:Date;
  dateUpdate:Date;
  dateString:string ="";
  dateStringUpdate:string ="";

  file1:File = null;
  file2:File = null;
  file3:File = null;
  files:File[] = [];

  file1History:File = null;
  file2History:File = null;
  file3History:File = null;

  file1Update:File = null;
  file2Update:File = null;
  file3Update:File = null;
  filesUpdate:File[] = [];



  constructor(private travelExpenseService:TravelExpenseService,
              private customerService:CustomerService,
              private travelExpenseDetailService:TravelExpenseDetailService,
              private router: Router) {
       
   }

  ngOnInit() {
    console.log("TravelExpenseId in TravelExpenseDetail: "+this.travelExpenseId);
    console.log("AppUserId: "+this.appUserId);
    this.travelExpenseDetail.expense = 0;
    this.travelExpenseDetail.expWayExpense = 0;
  }



   private myDatePickerOptions: IMyOptions = {
        // other options...
        dateFormat: 'yyyy-mm-dd'

  }

  onDateChanged(event: IMyDateModel) {
      console.log(event.date)
      console.log(event.formatted);
      this.dateString = event.date.year+"-"+this.checkDateForm(event.date.month)+"-"+this.checkDateForm(event.date.day);
      //this.dateString = date;
      //this.date = this.stringToDate(date,"yyyy-mm-dd","-");
      //this.travelExpenseDetail.travelDate = Date.parse(this.dateString)
      console.log(this.dateString);
      
      
    //   console.log("DATE: "+this.date);
    //   //2017-02-01
    //   //console.log(date.split('-'));
    //   //["2017","02","01"]
    //  this.travelExpenseDetail.travelDate =  this.date.getTime();
    //    console.log("event.date: "+this.travelExpenseDetail.travelDate);
  }

    onDateChangedUpdate(event: IMyDateModel) {
      var date = event.date.year+"-"+this.checkDateForm(event.date.month)+"-"+this.checkDateForm(event.date.day);
      this.dateStringUpdate = date;
      // this.dateUpdate = this.stringToDate(date,"yyyy-mm-dd","-");
      
      // this.travelExpenseDetailUpdate.travelDate =  this.dateUpdate.getTime();
      
      //  console.log("event.date: "+this.travelExpenseDetailUpdate.travelDate);
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

onChangeFile(event:EventTarget,num:number){
  let eventObj: MSInputMethodContext;
  let target: HTMLInputElement;
  let files: FileList;

  if(num == 1){
    eventObj = <MSInputMethodContext> event;
    target = <HTMLInputElement> eventObj.target;
    files = target.files;
    this.file1 = files[0];
    console.log(this.file1);

  }else if(num == 2){
    eventObj = <MSInputMethodContext> event;
    target = <HTMLInputElement> eventObj.target;
    files = target.files;
    this.file2 = files[0];
    console.log(this.file2);

  }else if(num == 3){
    eventObj = <MSInputMethodContext> event;
    target = <HTMLInputElement> eventObj.target;
    files = target.files;
    this.file3 = files[0];
    console.log(this.file3);
  }
    // this.files.push(this.file1);
    // this.files.push(this.file2);
    // this.files.push(this.file3);
    // console.log(this.files);
}

onChangeFileUpdate(event:EventTarget,num:number){
  let eventObj: MSInputMethodContext;
  let target: HTMLInputElement;
  let files: FileList;

  if(num == 1){
    eventObj = <MSInputMethodContext> event;
    target = <HTMLInputElement> eventObj.target;
    files = target.files;
    this.file1Update = files[0];
    console.log(this.file1Update);

  }else if(num == 2){
    eventObj = <MSInputMethodContext> event;
    target = <HTMLInputElement> eventObj.target;
    files = target.files;
    this.file2Update = files[0];
    console.log(this.file2Update);

  }else if(num == 3){
    eventObj = <MSInputMethodContext> event;
    target = <HTMLInputElement> eventObj.target;
    files = target.files;
    this.file3Update = files[0];
    console.log(this.file3Update);
  }
    // this.files.push(this.file1);
    // this.files.push(this.file2);
    // this.files.push(this.file3);
    // console.log(this.files);
}
  

  onClear(){
    this.file1History = this.file1;
    this.file2History = this.file2;
    this.file3History = this.file3;

    this.travelExpenseDetail.travelDate = null;
    this.travelExpenseDetail.customer = null;
    this.travelExpenseDetail.travelFrom = "";
    this.travelExpenseDetail.travelTo = "";
    this.travelExpenseDetail.expense = null;
    this.travelExpenseDetail.expWayExpense=null;
    this.travelExpenseDetail.expenseSubSummary=null;
    this.travelExpenseDetail.comment ="";
    this.travelExpenseDetail.attachFile1="";
    this.travelExpenseDetail.attachFile2="";
    this.travelExpenseDetail.attachFile3="";
    this.file1=null;
    this.file2=null;
    this.file3=null;
    this.files = [];
    this.inputFile1.nativeElement.value="";
    this.inputFile2.nativeElement.value="";
    this.inputFile3.nativeElement.value="";
  }

  detailModalUpdate(travelExpenseDetail){
    console.log(travelExpenseDetail)
    this.travelExpenseDetailUpdate = travelExpenseDetail;
    console.log(this.travelExpenseDetailUpdate.attachFile1);
    console.log(this.travelExpenseDetailUpdate.attachFile2);
    console.log(this.travelExpenseDetailUpdate.attachFile3);
  }

  onClearUpdate(travelDate:HTMLInputElement,customer:HTMLInputElement,travelFrom:HTMLInputElement,
                travelTo:HTMLInputElement,expense:HTMLInputElement,expWayExpense:HTMLInputElement
                ,expenseSubSummary:HTMLInputElement,comment:HTMLInputElement,
                attachFileUpdate1,attachFileUpdate2,attachFileUpdate3){
      travelDate.value = this.travelExpenseDetailUpdate.travelDate.toString();
      customer.value = this.travelExpenseDetailUpdate.customer.toString();
      travelFrom.value = this.travelExpenseDetailUpdate.travelFrom;
      travelTo.value = this.travelExpenseDetailUpdate.travelTo;
      expense.value = this.travelExpenseDetailUpdate.expense.toString();
      expWayExpense.value = this.travelExpenseDetailUpdate.expWayExpense.toString();
      expenseSubSummary.value = this.travelExpenseDetailUpdate.expenseSubSummary.toString();
      comment.value = this.travelExpenseDetailUpdate.comment;
      // attachFileUpdate1.value = this.travelExpenseDetailUpdate.attachFile1;
      // attachFileUpdate2.value = this.travelExpenseDetailUpdate.attachFile2;
      // attachFileUpdate3.value = this.travelExpenseDetailUpdate.attachFile3;
      this.file1Update = null;
      this.file2Update = null;
      this.file3Update = null;
      this.inputFileUpdate1.nativeElement.value="";
      this.inputFileUpdate2.nativeElement.value="";
      this.inputFileUpdate3.nativeElement.value="";
      console.log(this.travelExpenseDetailUpdate);

  }

  

  validateNegative(event){
      console.log(event.target.value.match(/[^\d.]/g));
      if(event.target.value!=null &&  (event.target.value.match(/[^\d.]/g)) ){
        event.target.value = "";
      }else if(event.target.value==null)
       event.target.value = 0;
      
  }
  sumTravelExpenseSubSummary(expense:HTMLInputElement,expWayExpense:HTMLInputElement){
    var total = 0;
    console.log("expense = "+this.travelExpenseDetail.expense)
    console.log("Wayexpense = "+this.travelExpenseDetail.expWayExpense)
    if(expense.value == ""){
      this.travelExpenseDetail.expense = 0;
      expense.value= "0";
    } 
    if(expWayExpense.value == ""){
      this.travelExpenseDetail.expWayExpense = 0;
      expWayExpense.value = "0";
    }
    total= parseFloat(expense.value) + parseFloat(expWayExpense.value);
    this.travelExpenseDetail.expenseSubSummary = total;
  }

  sumTravelExpenseSubSummaryUpdate(expense:HTMLInputElement,expWayExpense:HTMLInputElement){
    var total = 0;
    console.log("expense = "+this.travelExpenseDetailUpdate.expense)
    console.log("Wayexpense = "+this.travelExpenseDetailUpdate.expWayExpense)
    if(expense.value == ""){
      this.travelExpenseDetailUpdate.expense = 0;
      expense.value= "0";
    } 
    if(expWayExpense.value == ""){
      this.travelExpenseDetailUpdate.expWayExpense = 0;
      expWayExpense.value = "0";
    }
    total= parseFloat(expense.value) + parseFloat(expWayExpense.value);
    this.travelExpenseDetailUpdate.expenseSubSummary = total;
  }

  gotoListSentApprove(){
    console.log(this.appUserId);

    this.router.navigate(['/listSentApprove', this.appUserId]);
  }

  addTravelExpenseDetail(){
   // console.log(this.travelExpenseDetail.travelDate);
    console.log(this.dateString);
    this.files.push(this.file1);
    this.files.push(this.file2);
    this.files.push(this.file3);
    console.log(this.files);
   // this.travelExpenseDetail.travelDate = this.date.getTime();
    this.travelExpenseDetailService.addTravelExpenseDetail(this.travelExpenseDetail,this.travelExpenseId,
                                                            this.files,this.dateString)
      .subscribe(
        data => console.log(JSON.stringify(data)),
        error => console.log(error),
        () => {console.log("Add Detail Success"),
                this.onClear(),
                this.getTravelExpenseDetailsByTravelExpenseId()
                 }
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
          console.log("dateUpdate:"+this.dateStringUpdate);
          console.log("cusUpdate:"+this.customerIdUpdate);
          if(this.file1Update == null){
            console.log("into null fileUpdate");
            this.file1Update = this.file1History;
            console.log(this.file1Update);
          }

          if(this.file2Update == null){
            this.file2Update = this.file2History;
            console.log(this.file2Update);
          }

          if(this.file3Update == null){
            this.file3Update = this.file3History;
            console.log(this.file3Update);
          }
          
          if(this.customerIdUpdate != null){
            this.travelExpenseDetailUpdate.customer.id = this.customerIdUpdate;
          }

          if(this.dateStringUpdate == ""){
            this.dateStringUpdate = this.dateString;
          }

          this.filesUpdate.push(this.file1Update);
          this.filesUpdate.push(this.file2Update);
          this.filesUpdate.push(this.file3Update);
          console.log(this.filesUpdate);

          this.travelExpenseDetailUpdate.travelFrom = travelFrom.value;
          this.travelExpenseDetailUpdate.travelTo = travelTo.value;
          this.travelExpenseDetailUpdate.expense = parseInt(expense.value); 
          this.travelExpenseDetailUpdate.expWayExpense = parseInt(expWayExpense.value);
          this.travelExpenseDetailUpdate.expenseSubSummary = parseInt(expenseSubSummary.value);
          this.travelExpenseDetailUpdate.comment = comment.value;

          this.travelExpenseDetailService.updateTravelExpenseDetail(this.travelExpenseDetailUpdate,this.travelExpenseId
                                                                    ,this.filesUpdate,this.dateStringUpdate)
            .subscribe(
              data => console.log(JSON.stringify(data)),
              error => console.log(error),
              () => {console.log("Update Detail Success"),
                      this.file1Update = null,
                      this.file2Update = null,
                      this.file3Update = null,
                      this.filesUpdate = [],
                      this.getTravelExpenseDetailsByTravelExpenseId(),
                      this.customerIdUpdate = null }
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
          data => {this.travelExpenseDetails = data},
          error => console.log(error),
          () => {
            alert("Get TravelExpenseDetails Success");
            this.calculateExpenseResult();
                
          }
        )
  }

 addExpenseSummary(){
   this.travelExpenseService.addExpenseSummary(this.expenseSummary,this.travelExpenseId)
        .subscribe(
          data =>  console.log(data),
          error => console.log(error),
          () => {
            alert("Save Expense Summary Complete"),
            this.router.navigate(['/listSentApprove', this.appUserId]);
          }

        )
 }

 calculateExpenseResult(){
   this.expenseResult = 0;
   this.expenseWayResult = 0;
   this.expenseSummary = 0;
   for(var i = 0 ; i < this.travelExpenseDetails.length ;i++){
     console.log(this.travelExpenseDetails[i].expense);
     console.log(this.travelExpenseDetails[i].expWayExpense);
     this.expenseResult += this.travelExpenseDetails[i].expense;
     this.expenseWayResult += this.travelExpenseDetails[i].expWayExpense;
     this.expenseSummary += this.travelExpenseDetails[i].expenseSubSummary;
   }
   console.log("Expense Result: "+this.expenseResult);
   console.log("ExpWay  Result: "+this.expenseWayResult);
   console.log("ExpenseSummary : "+this.expenseSummary);
 }  



 showPreview(filenumber:number){
    console.log("travelExpenseDetailUpdate id : "+this.travelExpenseDetailUpdate.id);
    this.travelExpenseDetailService.showPreview(this.travelExpenseDetailUpdate.id,filenumber)
 }

}
