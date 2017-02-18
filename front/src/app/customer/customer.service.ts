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

import { Customer } from './customer'
import { ConfigModeServerService } from '../config-mode-server.service'
@Injectable()


export class CustomerService {
    
constructor(private _http:Http,private configModeServerService:ConfigModeServerService) { }

  getCustomers(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get(this.configModeServerService.ipServer+'/customers/getCustomers',{
       headers : headers
     })
         .map(res => <Customer[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
           
   }

    addCustomer(code:string,name:string,active:number,address:string){
        var json = JSON.stringify({ code :code, name:name, active:active, address:address  });
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post(this.configModeServerService.ipServer+'/customers/addCustomer', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))
            
    }

    deleteCustomer(id:number){
        return this._http.delete(this.configModeServerService.ipServer+'/customers/deleteCustomer/'+id)
                        .map(res =>res.json())
                        .catch((error:Response) => Observable.throw(error.text()))
    }


  

    updateCustomer(customer:Customer){
        var json = JSON.stringify(customer);
        //var params = 'json=' + json;
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put(this.configModeServerService.ipServer+'/customers/updateCustomer', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))

    }

}
