import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-view-company',
  templateUrl: './view-company.component.html',
  styleUrls: ['./view-company.component.css']
})
export class ViewCompanyComponent implements OnInit {
  public company: Company;

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.message = "";
  }

  public getCompanyClick(): void {
    this.adminService.getCompany().subscribe(userMessageAndCompany => {
      this.company = userMessageAndCompany.company;
      this.adminService.message = userMessageAndCompany.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}
