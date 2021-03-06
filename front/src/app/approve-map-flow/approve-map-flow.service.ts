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

import { AppUser } from '../app-user/app-user';
import { ApproveMapFlow } from '../approve-map-flow/approve-map-flow';
import { ConfigModeServerService } from '../config-mode-server.service';

@Injectable()
export class ApproveMapFlowService {


  constructor(private _http:Http,private configModeServerService:ConfigModeServerService) { }

  getApproveMapFlows(){
    var headers = new Headers();
    headers.append("Content-Type","application/json");
     return this._http.get(this.configModeServerService.ipServer+'/approveMapFlows/getApproveMapFlows',{
       headers : headers
     })
         .map(res => <ApproveMapFlow[]>res.json())
         .catch((error:Response) => Observable.throw(error.text()))
           
   }

    addApproveMapFlow(employeeId:number,apv1Id:number,apv2Id:number,accountId:number){
        var json = JSON.stringify({employeeId:employeeId,apv1Id:apv1Id,
                                    apv2Id:apv2Id,accountId:accountId});
        var headers = new Headers();
        headers.append("Content-Type","application/json");

        return this._http.post(this.configModeServerService.ipServer+'/approveMapFlows/addApproveMapFlow', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))
            
    }

    deleteApproveMapFlow(id:number){
        return this._http.delete(this.configModeServerService.ipServer+'/approveMapFlows/deleteApproveMapFlow/'+id)
                        .map(res =>res.json())
                        .catch((error:Response) => Observable.throw(error.text()))
    }


  

    updateApproveMapFlow(apvmfId:number,employeeId:number,apv1Id:number,apv2Id:number,accountId:number){
        var json = JSON.stringify({apvmfId:apvmfId,employeeId:employeeId,apv1Id:apv1Id,
                                    apv2Id:apv2Id,accountId:accountId});
        console.log("employeeId= "+employeeId);
        var headers = new Headers();
        headers.append("Content-Type","application/json");
        return this._http.put(this.configModeServerService.ipServer+'/approveMapFlows/updateApproveMapFlow', json,
            {
                headers: headers
            })
            .map(res => res.json())
            .catch((error:Response) => Observable.throw(error.text()))

    }

}
