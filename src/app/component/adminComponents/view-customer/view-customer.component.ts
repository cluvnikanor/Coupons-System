import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Customer } from 'src/models/customer';
import { UserMessageAndCustomer } from 'src/models/user-message-and-customer';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  public customer: Customer;

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.message = "";
  }

  public getCustomerClick(): void {
    this.adminService.getCustomer().subscribe(userMessageAndCustomer => {
      this.customer = userMessageAndCustomer.customer;
      this.adminService.message = userMessageAndCustomer.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}

