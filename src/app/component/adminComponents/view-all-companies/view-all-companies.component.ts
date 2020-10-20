import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Company } from 'src/models/company';
import { UserMessageAndCompanies } from 'src/models/user-message-and-companies';

@Component({
  selector: 'app-view-all-companies',
  templateUrl: './view-all-companies.component.html',
  styleUrls: ['./view-all-companies.component.css']
})
export class ViewAllCompaniesComponent implements OnInit {
  public companies: Company[] = [new Company];

  constructor(public adminService: AdminService) { }

  ngOnInit() {
      this.adminService.getAllCompanies().subscribe(userMessageAndCompanies => {
        this.companies = userMessageAndCompanies.companies;
        this.adminService.message = userMessageAndCompanies.message;
      }, err => {
        // console.log(err.message)
        alert(err.error.message)
        // this.adminService.message = err.message
      });
    
  }


}
