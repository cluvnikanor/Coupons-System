import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  // public email: string = "";
  // public password: string = "";
  // public type: string = "";
  // public name: string = "";
  // public firstName: string = "";
  // public lastName: string = "";
  public register: boolean = false;

  constructor(public loginService: LoginService, public shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.register = false;
  }

  public loginClick(): void {
    if (this.loginService.email && this.loginService.password && this.loginService.type) {
      // this.loginService.type = this.type;
      // this.loginService.email = this.email;
      // this.loginService.password = this.password;
      this.loginService.login().subscribe(c => { this.shareDataService.userResponse = c; },
        err => {
          // console.log(err.message) 
          alert(err.error.message)
        });
    }
  }

  public logout(): void {
    this.loginService.token = this.shareDataService.userResponse.token;
    this.loginService.logout().subscribe(c => { this.shareDataService.userResponse = c; },
      err => {
        // console.log(err.message)
        alert(err.error.message)
      });
    this.shareDataService.showApp[0];
  }

  public registerClick(): void {
    this.register = true;
    if (this.loginService.type == "COMPANY") {
      this.companyRegister();
    }
    if (this.loginService.type == "CUSTOMER") {
      this.customerRegister();
    }
  }

  public companyRegister(): void {
    if (this.loginService.company.name && this.loginService.company.email != ""
      && this.loginService.company.password != "") {
      // this.loginService.company.name = this.name;
      // this.loginService.company.email = this.email;
      // this.loginService.company.password = this.password;
      this.loginService.companyRegister(this.loginService.company).subscribe(
        c => { this.shareDataService.userResponse = c; },
        err => {
          // console.log(err.message) 
          alert(err.error.message)
        });
      // { alert(this.shareDataService.userResponse.message });
    }
  }

  public customerRegister(): void {
    if (this.loginService.customer.firstName && this.loginService.customer.lastName
      && this.loginService.customer.email != "" && this.loginService.customer.password != "") {
      // this.loginService.customer.firstName = this.firstName;
      // this.loginService.customer.lastName = this.lastName;
      // this.loginService.customer.email = this.email;
      // this.loginService.customer.password = this.password;
      this.loginService.customerRegister(this.loginService.customer).subscribe(
        c => { this.shareDataService.userResponse = c; },
        err => {
          // console.log(err.message) 
          alert(err.error.message)
        });
      // alert(this.shareDataService.userResponse.message);
    }
  }

}
