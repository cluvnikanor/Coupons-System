import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { ShareDataService } from 'src/app/services/share-data.service';
import { Customer } from 'src/models/customer';

@Component({
  selector: 'app-view-all-customers',
  templateUrl: './view-all-customers.component.html',
  styleUrls: ['./view-all-customers.component.css']
})
export class ViewAllCustomersComponent implements OnInit {
  public editNow: boolean = false;
  public addNow: boolean = false;
  public filtering: boolean = false;
  public email: string = "";
  public customers: Customer[] = [new Customer];
  public customer: Customer = new Customer;

  constructor(public adminService: AdminService, private shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.adminService.message = "";
    this.getAllCustomers();
  }

  public editCustomer(c: Customer) {
    this.customer = c;
    this.editNow = true;
  }

  public addCustomer() {
    this.customer = new Customer;
    this.editNow = true;
    this.addNow = true;
  }

  private getAllCustomers(): void {
    this.adminService.getAllCustomers().subscribe(userMessageAndCompanies => {
      this.customers = userMessageAndCompanies.customers;
      this.adminService.message = userMessageAndCompanies.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
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
      this.editNow = false;
    }
  }

  public updateCustomerClick(): void {
    this.adminService.customer = this.customer;
    this.adminService.updateCustomer2().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
    });
    this.editNow = false;
  }

  public deleteCustomerClick(): void {
    this.adminService.email = this.customer.email;
    this.adminService.deleteCustomer().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
    this.editNow = false;
  }

}
