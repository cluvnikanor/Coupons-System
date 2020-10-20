import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Coupon } from 'src/models/coupon';

@Component({
  selector: 'app-add-coupon',
  templateUrl: './add-coupon.component.html',
  styleUrls: ['./add-coupon.component.css']
})
export class AddCouponComponent implements OnInit {
  public coupon: Coupon = new Coupon;
  public currentDate: Date;

  constructor(public companyService: CompanyService) { }

  ngOnInit() {
    this.currentDate = new Date();
    this.companyService.message = "";
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

}
