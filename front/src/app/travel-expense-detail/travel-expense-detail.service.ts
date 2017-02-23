import { Injectable } from '@angular/core';
import { Location } from '@angular/common';

import { Headers, Http, Response,RequestOptions } from '@angular/http';

// Add the RxJS Observable operators.
import { Observable }     from 'rxjs/Observable';
// Statics
import 'rxjs/add/observable/throw';
// Operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/toPromise';

import { TravelExpenseDetail } from '../travel-expense-detail/travel-expense-detail'
import { ConfigModeServerService } from '../config-mode-server.service';

@Injectable()
export class TravelExpenseDetailService {

  constructor(private _http:Http,private location :Location,
              private configModeServerService:ConfigModeServerService) {
    console.log(location.prepareExternalUrl(location.path()));
   }

  addTravelExpenseDetail(travelExpenseDetail:TravelExpenseDetail,travelExpenseId:number,
                         files:File[],dateString:string){
    console.log("travelDate : "+dateString);
    console.log("InService: "+travelExpenseId);
      let formData : FormData = new FormData();
      for(let i = 0 ; i < files.length ; i++){
        if(files[i] != null){
          formData.append("file"+(i+1),files[i]);
          formData.append("attachFile"+(i+1),files[i].name);
        }else{
          formData.append("file"+(i+1),null);
          formData.append("attachFile"+(i+1),"");
        }
      }
      console.log("attachFile1: "+files[0])
      console.log("attachFile2: "+files[1])
      console.log("attachFile3: "+files[2])
      formData.append("customer",travelExpenseDetail.customer);
      formData.append("travelFrom",travelExpenseDetail.travelFrom);
      formData.append("travelTo",travelExpenseDetail.travelTo);
      formData.append("expense",travelExpenseDetail.expense);
      formData.append("expWayExpense",travelExpenseDetail.expWayExpense);
      formData.append("expenseSubSummary",travelExpenseDetail.expenseSubSummary);
      formData.append("travelDate",dateString);
      formData.append("comment",travelExpenseDetail.comment);
      formData.append("travelExpense",travelExpenseId);
      console.log(formData);
      var headers = new Headers();
      headers.append("Content-Type","application/json");
      return this._http.post(this.configModeServerService.ipServer+'/travelExpenseDetails/addTravelExpenseDetail',formData,headers)
          .map(res => res.json())
          .catch((error:Response) => Observable.throw(error.text()))     
  }

  updateTravelExpenseDetail(travelExpenseDetail:TravelExpenseDetail,travelExpenseId:number,
                            customerId:number,travelExpenseDetailDate:number){
    console.log("travelDate in Update : "+travelExpenseDetail.travelDate);
    console.log("InService: "+travelExpenseId);
    console.log("customerId : "+customerId);
      var headers = new Headers();
      var json = JSON.stringify({travelExpenseDetail:travelExpenseDetail,travelExpenseId:travelExpenseId
                                , customerId:customerId, date:travelExpenseDetailDate})
      headers.append("Content-Type","application/json");
      return this._http.put(this.configModeServerService.ipServer+'/travelExpenseDetails/updateTravelExpenseDetail',json,{
        headers : headers
      })
          .map(res => res.json())
          .catch((error:Response) => Observable.throw(error.text()))
  }

  getTravelExpenseDetails(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
    return this._http.get(this.configModeServerService.ipServer+'/travelExpenseDetails/getTravelExpenseDetails',{
      headers:headers
    })
      .map(res => res.json())
      .catch((error:Response) => Observable.throw(error.text()))
  }


getTravelExpenseDetailsByTravelExpenseId(travelExpenseId:number){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
    return this._http.post(this.configModeServerService.ipServer+'/travelExpenseDetails/getTravelExpenseDetailsByTravelExpenseId?travelExpenseId='+travelExpenseId,{
      headers:headers
    })
      .map(res => res.json())
      .catch((error:Response) => Observable.throw(error.text()))
  }

  deleteTravelExpenseDetail(travelExpenseDetailId:number){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
    return this._http.delete(this.configModeServerService.ipServer+'/travelExpenseDetails/deleteTravelExpenseDetail/'+travelExpenseDetailId,{
      headers:headers
    })
      .map(res => res.json())
      .catch((error:Response) => Observable.throw(error.text()))
  }

}
