import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Coupon } from 'src/models/coupon';

@Component({
  selector: 'app-coupon-purchase',
  templateUrl: './coupon-purchase.component.html',
  styleUrls: ['./coupon-purchase.component.css']
})
export class CouponPurchaseComponent implements OnInit {
  public addNow: boolean = false;
  public filtering: boolean = false;
  // public coupon: Coupon = new Coupon;
  public coupons: Coupon[] = [new Coupon];
  public categoryFilter: number = 1;
  public maxPriceFilter: number = Infinity;

  constructor(public customerService: CustomerService) { }

  ngOnInit() {
    this.getAllCoupons();
  }

  private getAllCoupons() {
    this.customerService.getAllCoupons().subscribe(userMessageAndCoupons => {
      this.coupons = userMessageAndCoupons.coupons;
      this.customerService.message = userMessageAndCoupons.message;
    }, err => {
      alert(err.error.message)
    });
  }

  public couponPurchase(couponId: number) {
    this.customerService.couponId = couponId;
    this.customerService.couponPurchase().subscribe(userMessage => {
      this.customerService.message = userMessage.message;
    }, err => {
      alert(err.error.message)
    });
  }

}
