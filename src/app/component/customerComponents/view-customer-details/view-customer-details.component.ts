import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from 'src/models/customer';
import { UserMessageAndCustomer } from 'src/models/user-message-and-customer';

@Component({
  selector: 'app-view-customer-details',
  templateUrl: './view-customer-details.component.html',
  styleUrls: ['./view-customer-details.component.css']
})
export class ViewCustomerDetailsComponent implements OnInit {
  public customer: Customer;

  constructor(public customerService: CustomerService) { }

  ngOnInit() {
    this.getCustomerDetails();
  }

  private getCustomerDetails(): void {
    this.customerService.getCustomerDetails().subscribe(userMessageAndCustomer => {
      this.customer = userMessageAndCustomer.customer;
      this.customerService.message = userMessageAndCustomer.message;
    }, err => {
      alert(err.error.message)
    });
  }

}
