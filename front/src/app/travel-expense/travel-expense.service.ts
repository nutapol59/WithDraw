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

@Injectable()
export class TravelExpenseService {

  constructor(private _http:Http) { }

  getTravelExpenses(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get('http://localhost:8080/travelExpenses/getTravelExpenses',{
       headers : headers
     })
         .map(res => <TravelExpense[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
           
   }

}
