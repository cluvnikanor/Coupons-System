import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { CompanyService } from 'src/app/services/company.service';
import { CustomerService } from 'src/app/services/customer.service';
import { LoginService } from 'src/app/services/login.service';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public shareDataService: ShareDataService, public customerService: CustomerService,
    public loginService: LoginService, public adminService: AdminService,
    public companyService: CompanyService) { }

  ngOnInit() {
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

}
