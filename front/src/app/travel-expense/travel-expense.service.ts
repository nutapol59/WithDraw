import { Injectable } from '@angular/core';

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

import { TravelExpense } from './travel-expense'
import { AppUser } from '../app-user/app-user';
import { Company } from '../company/company';
import { Department } from '../department/department';

import { ConfigModeServerService } from '../config-mode-server.service';

@Injectable()
export class TravelExpenseService {

  constructor(private _http:Http,private configModeServerService : ConfigModeServerService) { }

  getTravelExpenses(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get(this.configModeServerService.ipServer+'/travelExpenses/getTravelExpenses',{
       headers : headers
     })
         .map(res => <TravelExpense[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
           
   }

  getTravelExpensesByAppUserId(appUserId:number){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.post(this.configModeServerService.ipServer+'/travelExpenses/getTravelExpensesByAppUserId?appUserId='+appUserId,{
       headers : headers
     })
         .map(res => <TravelExpense[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
  }
   addTravelExpense(appUserId:number, companyId:number, departmentId:number, comment:string){
     console.log(appUserId);
      var headers = new Headers();
      var json = JSON.stringify({appUserId:appUserId, companyId:companyId,
                                  departmentId:departmentId,comment:comment})
      headers.append("Content-Type","application/json");
      return this._http.post(this.configModeServerService.ipServer+'/travelExpenses/addTravelExpense',json,{
        headers : headers
      })
          .map(res => res.json())
          .catch((error:Response) => Observable.throw(error.text()))
           
   }
   
   addExpenseSummary(expenseSummary:number,travelExpenseId:number){
      var headers = new Headers();
      var json  = JSON.stringify({expenseSummary:expenseSummary,travelExpenseId:travelExpenseId});
      headers.append("Content-Type", "application/json");
      return this._http.post(this.configModeServerService.ipServer+'/travelExpenses/addExpenseSummary',json,{
        headers:headers
      })
          .map(res => res.json())
          .catch((error:Response) => Observable.throw(error.text()))

   }

   updateTravelExpense(travelExpenseId:number, comment:string){
     console.log(travelExpenseId);
      var headers = new Headers();
      var json = JSON.stringify({travelExpenseId:travelExpenseId, comment:comment})
      headers.append("Content-Type","application/json");
      return this._http.put(this.configModeServerService.ipServer+'/travelExpenses/updateTravelExpense',json,{
        headers : headers
      })
          .map(res => res.json())
          .catch((error:Response) => Observable.throw(error.text()))
           
   }

}
