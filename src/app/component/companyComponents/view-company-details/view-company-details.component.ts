import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-view-company-details',
  templateUrl: './view-company-details.component.html',
  styleUrls: ['./view-company-details.component.css']
})
export class ViewCompanyDetailsComponent implements OnInit {
  public company: Company;

  constructor(public companyService: CompanyService) { }

  ngOnInit() {
    this.getCompanyDetails();
  }

  private getCompanyDetails(): void {
    this.companyService.getCompanyDetails().subscribe(userMessageAndCompany => {
      this.company = userMessageAndCompany.company;
      this.companyService.message = userMessageAndCompany.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}
