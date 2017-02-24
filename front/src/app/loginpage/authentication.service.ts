/**
 * Created by Baze on 2/24/2017.
 */
import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import {Observable, Subject} from 'rxjs';
import 'rxjs/add/operator/map'
import { ConfigModeServerService } from '../config-mode-server.service';
import {Router} from "@angular/router";

@Injectable()
export class AuthenticationService {
  public token;
  tokenChange: Subject<boolean> = new Subject<boolean>();

  constructor(private http: Http
    ,private configModeServerService: ConfigModeServerService
    ,private router: Router) {
    // set token if saved in local storage
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
    this.tokenChange.next(false);
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post(this.configModeServerService.ipServer+'/AuthenticationUser/login', JSON.stringify({ username: username, password: password }))
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let token = response.json();
        // alert(token)
        if (token != -1) {
          // set token property
          this.token = token;
          this.tokenChange.next(true);
          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));

          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      });
  }

  change(){
    this.token = this.token;
  }

  logout(): void {
    // clear token remove user from local storage to log user out
    this.token = -1;
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }
}
