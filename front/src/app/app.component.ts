import {Component} from '@angular/core';
import {AuthenticationService} from "./loginpage/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'app works!';
  // isLoggedIn = null;
  constructor(private authenticationService: AuthenticationService){
    // this.isLoggedIn = authenticationService.result;
    // console.log(this.isLoggedIn);
  }
}
