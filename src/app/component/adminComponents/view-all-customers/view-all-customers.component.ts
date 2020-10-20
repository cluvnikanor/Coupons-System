import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Customer } from 'src/models/customer';

@Component({
  selector: 'app-view-all-customers',
  templateUrl: './view-all-customers.component.html',
  styleUrls: ['./view-all-customers.component.css']
})
export class ViewAllCustomersComponent implements OnInit {
  public customers: Customer[] = [new Customer];

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.getAllCustomers().subscribe(userMessageAndCompanies => {
      this.customers = userMessageAndCompanies.customers;
      this.adminService.message = userMessageAndCompanies.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });

  }

}
