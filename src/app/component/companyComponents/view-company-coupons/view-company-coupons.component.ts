import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Coupon } from 'src/models/coupon';

@Component({
  selector: 'app-view-company-coupons',
  templateUrl: './view-company-coupons.component.html',
  styleUrls: ['./view-company-coupons.component.css']
})
export class ViewCompanyCouponsComponent implements OnInit {
  public editNow: boolean = false;
  public addNow: boolean = false;
  public filtering: boolean = false;
  public coupon: Coupon = new Coupon;
  public coupons: Coupon[] = [new Coupon];
  public categoryFilter: number = 1;
  public maxPriceFilter: number = Infinity;

  constructor(public companyService: CompanyService) { }

  ngOnInit() {
    this.getAllCoupons();
  }

  private getAllCoupons() {
    this.companyService.getAllCoupons().subscribe(userMessageAndCoupons => {
      this.coupons = userMessageAndCoupons.coupons;
      this.companyService.message = userMessageAndCoupons.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
      // this.adminService.message = err.message
    });
  }

  public editCoupon(c: Coupon) {
    this.coupon = c;
    this.editNow = true;
  }

  public addCoupon() {
    this.coupon = new Coupon;
    this.editNow = true;
    this.addNow = true;
  }

  public addCouponClick(): void {
    if (this.coupon.title && this.coupon.startDate && this.coupon.endDate && this.coupon.amount != 0) {
      this.companyService.addCoupon(this.coupon).subscribe(userMessage => {
        this.companyService.message = userMessage.message;
      }, err => {
        // console.log(err.message)
        alert(err.error.message)
      });
    }
  }

  public updateCompanyClick(): void {
    this.companyService.updateCoupon(this.coupon).subscribe(userMessage => {
      this.companyService.message = userMessage.message;
    }, err => {
      // console.log(err.message)
      alert(err.error.message)
    });
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