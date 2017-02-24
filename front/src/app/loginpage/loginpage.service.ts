/**
 * Created by Baze on 2/24/2017.
 */
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

// import { Department } from '../department/department';
// import { Company } from '../company/company';
import { ConfigModeServerService } from '../config-mode-server.service';
import {AuthenticationService} from "./authentication.service";
@Injectable()
export class LoginpageService {

  constructor(private _http: Http
    , private configModeServerService: ConfigModeServerService
    ,private authenticationService: AuthenticationService) {
  }

  // isValidUserLogin(username:String , password:String){
  //   var json = JSON.stringify({ username:username, password: password });
  //   var headers = new Headers();
  //   headers.append("Content-Type","application/json");
  //
  //   return this._http.post(this.configModeServerService.ipServer+'/AuthenticationUser/login', json,
  //     {
  //       headers: headers
  //     })
  //     .map(res => res.json())
  //     .catch((error:Response) => Observable.throw(error.text()))
  // }
}
