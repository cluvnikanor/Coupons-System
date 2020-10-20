import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Coupon } from 'src/models/coupon';

@Component({
  selector: 'app-view-all-coupons',
  templateUrl: './view-all-coupons.component.html',
  styleUrls: ['./view-all-coupons.component.css']
})
export class ViewAllCouponsComponent implements OnInit {
  public editNow: boolean = false;
  public coupon: Coupon = new Coupon;
  public coupons: Coupon[] = [new Coupon];

  constructor(public companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getAllCoupons().subscribe(userMessageAndCoupons => {
      this.coupons = userMessageAndCoupons.coupons;
      this.companyService.message = userMessageAndCoupons.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

  public edit(c: Coupon) {
    this.coupon = c;
    this.editNow = true;
  }

  public deleteCouponClick(): void {
    this.companyService.id = this.coupon.id;
    this.companyService.deleteCoupon().subscribe(userMessage => {
      this.companyService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

}