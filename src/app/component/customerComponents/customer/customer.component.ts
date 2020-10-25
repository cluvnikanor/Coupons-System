import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(public customerService: CustomerService, private shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.customerService.message ="";
  }

  public chooseApp(option: number): void {
    this.customerService.chooseApp(option);
  }

}
