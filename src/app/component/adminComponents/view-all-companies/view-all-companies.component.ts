import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { ShareDataService } from 'src/app/services/share-data.service';
import { Company } from 'src/models/company';
import { UserMessageAndCompanies } from 'src/models/user-message-and-companies';

@Component({
  selector: 'app-view-all-companies',
  templateUrl: './view-all-companies.component.html',
  styleUrls: ['./view-all-companies.component.css']
})
export class ViewAllCompaniesComponent implements OnInit {
  public editNow: boolean = false;
  public addNow: boolean = false;
  public filtering: boolean = false;
  public companies: Company[] = [new Company];
  public company: Company = new Company();
  public email: string = "";

  constructor(public adminService: AdminService, private shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.adminService.message = "";
    this.getAllCompanies();
  }

  public editCompany(c: Company) {
    this.company = c;
    this.editNow = true;
  }

  public addCompany() {
    this.company = new Company;
    this.editNow = true;
    this.addNow = true;
  }

  private getAllCompanies(): void {
    this.adminService.getAllCompanies().subscribe(userMessageAndCompanies => {
      this.companies = userMessageAndCompanies.companies;
      this.adminService.message = userMessageAndCompanies.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

  public addCompanyClick(): void {
    if (this.company.name && this.company.email && this.company.password) {
      this.adminService.addCompany(this.company).subscribe(userMessage => {
        this.adminService.message = userMessage.message;
      }, err => {
        // console.log(err.message)
        alert(err.error.message)
      });
      this.editNow = false;
    }
  }

  public updateCompanyClick(): void {
    if (this.company.email && this.company.password) {
      this.adminService.id = this.company.id;
      this.adminService.email = this.company.email;
      this.adminService.password = this.company.password;
      this.adminService.updateCompany2().subscribe(userMessage => {
        this.adminService.message = userMessage.message;
      }, err => {
        // console.log(err.message)
        alert(err.error.message)
      });
      this.editNow = false;
    }
  }

  public deleteCompanyClick(): void {
    this.adminService.email = this.company.email;
    this.adminService.deleteCompany().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
    this.editNow = false;
  }


}
