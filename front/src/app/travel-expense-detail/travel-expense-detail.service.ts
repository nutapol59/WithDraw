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

  addTravelExpenseDetail(travelExpenseDetail:TravelExpenseDetail,travelExpenseId:number,travelExpenseDetailDate:number){
    console.log(JSON.stringify(travelExpenseDetail));
    console.log("travelDate : "+travelExpenseDetailDate);
    console.log("InService: "+travelExpenseId);

      var headers = new Headers();
      var json = JSON.stringify({travelExpenseDetail:travelExpenseDetail,travelExpenseId:travelExpenseId,
                                  date:travelExpenseDetailDate})
      headers.append("Content-Type","application/json");
      return this._http.post(this.configModeServerService.ipServer+'/travelExpenseDetails/addTravelExpenseDetail',json,{
        headers : headers
      })
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
