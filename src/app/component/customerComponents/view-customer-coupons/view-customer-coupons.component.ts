import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { ShareDataService } from 'src/app/services/share-data.service';
import { Coupon } from 'src/models/coupon';

@Component({
  selector: 'app-view-customer-coupons',
  templateUrl: './view-customer-coupons.component.html',
  styleUrls: ['./view-customer-coupons.component.css']
})
export class ViewCustomerCouponsComponent implements OnInit {
  public addNow: boolean = false;
  public filtering: boolean = false;
  // public coupon: Coupon = new Coupon;
  public coupons: Coupon[] = [new Coupon];
  public categoryFilter: number = 1;
  public maxPriceFilter: number = Infinity;

  constructor(public customerService: CustomerService, private shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.getCustomerCoupons();
  }

  private getCustomerCoupons() {
    this.customerService.getCustomerCoupons().subscribe(userMessageAndCoupons => {
      this.coupons = userMessageAndCoupons.coupons;
      this.customerService.message = userMessageAndCoupons.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}
