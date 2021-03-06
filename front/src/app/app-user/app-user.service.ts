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

import { AppUser } from './app-user';
import { ConfigModeServerService } from '../config-mode-server.service';

@Injectable()
export class AppUserService {

  constructor(private _http: Http,private location:Location,
              private configModeServerService : ConfigModeServerService) {
      console.log("Path: "+window.location.hostname);
      
   }
  getAppUsers(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get(this.configModeServerService.ipServer+'/appUsers/getAppUsers',{
       headers : headers
     })
         .map(res => <AppUser[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
           
   }

   getAppUserById(id:number){
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.post(this.configModeServerService.ipServer+'/appUsers/getAppUserById?id='+id,{
        headers : headers
     })
         .map(res => <AppUser>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
   }

    addAppUser(empCode:string, empName:string, empLastName:string, empAddress:string, personalId:string,
              tel:string, email:string, ldapUserName:string, password:string, departmentId:number, companyId:number){

        var json = JSON.stringify({ empCode:empCode, empName:empName, empLastName:empLastName,
                                    empAddress:empAddress, personalId:personalId, tel:tel,
                                    email:email, ldapUserName:ldapUserName, password:password,
                                    departmentId:departmentId,companyId:companyId });
        
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post(this.configModeServerService.ipServer+'/appUsers/addAppUser', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))
            
    }

    deleteAppUser(id:number){
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.delete(this.configModeServerService.ipServer+'/appUsers/deleteAppUser/'+id,{
          headers: headers
        })
                        .map(res =>res.json())
                        .catch((error:Response) => Observable.throw(error.text()))
    }


  

    updateAppUser(id:number, empCode:string, empName:string, empLastName:string, empAddress:string, personalId:string,
              tel:string, email:string, ldapUserName:string, password:string, departmentId:number, companyId:number){
        var json = JSON.stringify({ id:id, empCode:empCode, empName:empName, empLastName:empLastName,
                                    empAddress:empAddress, personalId:personalId, tel:tel,
                                    email:email, ldapUserName:ldapUserName, password:password,
                                    departmentId:departmentId,companyId:companyId });
        //var params = 'json=' + json;
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put(this.configModeServerService.ipServer+'/appUsers/updateAppUser', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))

    }
}
