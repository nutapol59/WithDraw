import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../loginpage/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  show =false;
  id=-1;
  constructor(private authenticationService: AuthenticationService,private router: Router) {
    router.events.subscribe((val) => {
      // see also
      console.log(val)
      this.check();
      // console.log(val instanceof NavigationEnd)
    });

  }

  ngOnInit() {
    this.check();

  }

  // AfterViewInit(){
  //   this.check();
  // }
  logout(){
    this.show = false;
    // console.log(this.show)
    this.authenticationService.logout();
  }
  loginPage(){
    this.router.navigate(['/login']);
  }
  check(){
    // console.log(this.authenticationService.tokenChange)
    this.id = this.authenticationService.token;
    this.authenticationService.tokenChange.subscribe( value => {
      // console.log(value);
      if(value)
        this.show = true;
      else
        this.show = false;
    });
  }

}
