import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {

  constructor(public adminService: AdminService) { }

  ngOnInit() {
    this.adminService.message = "";
  }

  public deleteCustomerClick(): void {
    this.adminService.deleteCustomer().subscribe(userMessage => {
      this.adminService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}
