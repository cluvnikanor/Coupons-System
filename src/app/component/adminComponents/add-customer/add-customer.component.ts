import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Customer } from 'src/models/customer';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customer: Customer = new Customer();

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.customer.id = 0;
    this.adminService.message = "";
  }

  public addCustomerClick(): void {
    if (this.customer.firstName && this.customer.lastName && this.customer.email
      && this.customer.password) {
      this.adminService.addCustomer(this.customer).subscribe(userMessage => {
        this.adminService.message = userMessage.message;
      }, err => {
        // console.log(err.message)
        alert(err.error.message)
      });
    }
  }

}
