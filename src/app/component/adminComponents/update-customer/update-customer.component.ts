import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Customer } from 'src/models/customer';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customer: Customer = new Customer();

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.message = "";
  }

  public updateCustomerClick(): void {
    this.adminService.updateCustomer().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
    });
  }

}
