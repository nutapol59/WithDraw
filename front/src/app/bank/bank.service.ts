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

import { Bank } from './bank'

@Injectable()
export class BankService {
  constructor(private _http:Http) { }

  getBanks(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get('http://localhost:8080/banks/getBanks',{
       headers : headers
     })
         .map(res => <Bank[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
           
   }

    addBank(code:string,name:string,active:number){
        var json = JSON.stringify({ code :code, name:name,active:active });
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post('http://localhost:8080/banks/addBank', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))
            
    }

    deleteBank(id:number){
        return this._http.delete('http://localhost:8080/banks/deleteBank/'+id)
                        .map(res =>res.json())
                        .catch((error:Response) => Observable.throw(error.text()))
    }


  

    updateBank(bank:Bank){
        var json = JSON.stringify(bank);
        //var params = 'json=' + json;
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put('http://localhost:8080/banks/updateBank', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))

    }

}
