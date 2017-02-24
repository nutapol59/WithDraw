import { Component, OnInit } from '@angular/core';
import { LoginpageService } from "./loginpage.service";
import {AuthenticationService} from "./authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {

  username: string='';
  password: string='';
  public show=false;

  constructor( private router: Router
    ,private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.authenticationService.logout();
  }

  checkValidUserLogin(username: HTMLInputElement, password: HTMLInputElement){
    this.username = username.value;
    this.password = password.value;

    // this.loginpageService.isValidUserLogin(this.username, this.password)
    //   .subscribe(
    //   data => {
    //     alert(JSON.stringify(data)),
    //     localStorage.setItem('currentUser', JSON.stringify({ username: this.username, password: this.password, isActivated: data }))
    //   },
    //   error => alert(error),
    //   () => {
    //     console.log("------------check complete-----------"),
    //     console.log( JSON.parse(localStorage.getItem('currentUser')) )
    //   }
    // )
  }

  login(username: HTMLInputElement, password: HTMLInputElement) {
    // this.loading = true;
    this.authenticationService.login(username.value, password.value)
      .subscribe(result => {
        // console.log(result)
        if (result === true) {
          // login successful
          this.show = true;
          this.router.navigate(['/']);
        } else {
          // login failed
          // this.error = 'Username or password is incorrect';
          // this.loading = false;
          this.show = false;
          console.log('failed');
        }
      });

  }

}
