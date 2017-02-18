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
import { ConfigModeServerService } from '../config-mode-server.service'

@Injectable()
export class CompanyService {

  constructor(private _http:Http,private configModeServerService: ConfigModeServerService) { }
  getCompanies(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get(this.configModeServerService.ipServer+'/companies/getCompanies',{
       headers : headers
     })
         .map(res => <Company[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
         
           
   }

    addCompany(code:string,name:string,active:number){
        var json = JSON.stringify({ code :code, name:name,active:active });
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post(this.configModeServerService.ipServer+'/companies/addCompany', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))
            
    }

    deleteCompany(id:number){
        return this._http.delete(this.configModeServerService.ipServer+'/companies/deleteCompany/'+id)
                        .map(res =>res.json())
                        .catch((error:Response) => Observable.throw(error.text()))
    }


  

    updateCompany(company:Company){
        var json = JSON.stringify(company);
        //var params = 'json=' + json;
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put(this.configModeServerService.ipServer+'/companies/updateCompany', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))

    }
}
