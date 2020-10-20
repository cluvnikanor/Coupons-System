import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {
  company: Company = new Company();

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.message = "";
  }

  public updateCompanyClick(): void {
    this.adminService.updateCompany().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
    });
  }

}
