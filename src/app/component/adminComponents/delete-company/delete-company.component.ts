import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-delete-company',
  templateUrl: './delete-company.component.html',
  styleUrls: ['./delete-company.component.css']
})
export class DeleteCompanyComponent implements OnInit {

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.message = "";
  }

  public deleteCompanyClick(): void {
    this.adminService.deleteCompany().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}
