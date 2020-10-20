import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  company: Company = new Company();

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.company.id = 0;
    this.adminService.message = "";
  }

  public addCompanyClick(): void {
    if (this.company.name && this.company.email && this.company.password) {
      this.adminService.addCompany(this.company).subscribe(userMessage => {
        this.adminService.message = userMessage.message;
      }, err => {
        // console.log(err.message)
        alert(err.error.message)
      });
    }
  }

}
