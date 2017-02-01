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


import { Company } from './company'

@Injectable()
export class CompanyService {

  constructor(private _http:Http) { }
  getCompanies(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get('http://localhost:8080/companies/getCompanies',{
       headers : headers
     })
         .map(res => {
            // If request fails, throw an Error that will be caught
            if(res.status < 200 || res.status >= 300) {
               throw new Error('This request has failed ' + res.status);
            }
            // If everything went fine, return the response
            else {
               return <Company[]>res.json();
            }
         })
   }

    addCompany(code:string,name:string,active:number){
        var json = JSON.stringify({ code :code, name:name,active:active });
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post('http://localhost:8080/companies/addCompany', json,
            {
                headers: headers
            })
            .map(res => res.json());
    }

    deleteCompany(id:number){
        return this._http.delete('http://localhost:8080/companies/deleteCompany/'+id)
                        .map(res => res.text())
    }

    updateCompany(company:Company){
        var json = JSON.stringify(company);
        //var params = 'json=' + json;
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put('http://localhost:8080/companies/updateCompany', json,
            {
                headers: headers
            })
            .map(res => res.json());

    }
}
