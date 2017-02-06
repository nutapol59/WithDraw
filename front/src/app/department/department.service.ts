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

import { Department } from '../department/department';
import { Company } from '../company/company';

@Injectable()
export class DepartmentService {
    company = new Company;

  constructor(private _http:Http) { }

  getDepartments(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get('http://localhost:8080/departments/getDepartments',{
       headers : headers
     })
         .map(res => <Department[]>res.json())
         .catch((error:Response) => Observable.throw(error.text())) 
   }


    addDepartment(code:string,name:string,active:number,companyId:number){
        console.log("cccccccc"+"     "+companyId);
        var json = JSON.stringify({ code:code, name:name, active:active, companyId:companyId });
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post('http://localhost:8080/departments/addDepartment', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text())) 
    }

    deleteDepartment(id:number){
        return this._http.delete('http://localhost:8080/departments/deleteDepartment/'+id)
                        .map(res => res.text())
                        .catch((error:Response) => Observable.throw(error.text())) 
    }

    updateDepartment(id:number,code:string,name:string,active:number,companyId:number){
        console.log(companyId);
        var json = JSON.stringify({id:id,code:code,name:name,active:active,companyId:companyId});
        //var params = 'json=' + json;
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put('http://localhost:8080/departments/updateDepartment', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text())) 

    }

}
