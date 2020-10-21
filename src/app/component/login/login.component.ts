import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { ShareDataService } from 'src/app/services/share-data.service';
import { UserResponse } from 'src/models/user-response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  email: string = "";
  password: string = "";
  type: string = "";
  name: string = "";
  firstName: string = "";
  lastName: string = "";
  register: boolean = false;

  constructor(public loginService: LoginService,
    public shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.register = false;
  }

  public loginClick(): void {
    if (this.email && this.password && this.type) {
      this.loginService.type = this.type;
      this.loginService.email = this.email;
      this.loginService.password = this.password;
      this.loginService.login().subscribe(c => { this.shareDataService.userResponse = c; },
        err => { console.log(err.message) });
      // alert(this.shareDataService.userResponse.message);
    }
  }
  
  public logout(): void {
    this.loginService.token = this.shareDataService.userResponse.token;
    this.loginService.logout().subscribe(c => { this.shareDataService.userResponse = c; },
      err => { console.log(err.message) });
    this.shareDataService.showApp[0];
  }

  public registerClick(): void {
    this.register = true;
    if (this.type == "COMPANY") {
      this.companyRegister();
    }
    if (this.type == "CUSTOMER") {
      this.customerRegister();
    }
  }

  public companyRegister(): void {
    if (this.name && this.email != "" && this.password != "") {
      this.loginService.company.name = this.name;
      this.loginService.company.email = this.email;
      this.loginService.company.password = this.password;
      this.loginService.companyRegister(this.loginService.company).subscribe(
        c => { this.shareDataService.userResponse = c; },
        err => { console.log(err.message) });
      // alert(this.shareDataService.userResponse.message);
    }
  }
  
  public customerRegister(): void {
    if (this.firstName && this.lastName && this.email != "" && this.password != "") {
      this.loginService.customer.firstName = this.firstName;
      this.loginService.customer.lastName = this.lastName;
      this.loginService.customer.email = this.email;
      this.loginService.customer.password = this.password;
      this.loginService.customerRegister(this.loginService.customer).subscribe(
        c => { this.shareDataService.userResponse = c; },
        err => { console.log(err.message) });
      // alert(this.shareDataService.userResponse.message);
    }
  }

}
