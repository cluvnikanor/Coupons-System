import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coupon } from 'src/models/coupon';
import { UserMessage } from 'src/models/user-message';
import { UserMessageAndCoupon } from 'src/models/user-message-and-coupon';
import { UserMessageAndCoupons } from 'src/models/user-message-and-coupons';
import { ShareDataService } from './share-data.service';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private baseUrl = "http://localhost:8080/company/"
  public showApp: boolean[] = [false, false, false, false, false, false, false, false, false, false, false];
  public message: string ="";
  public id: number;
  public coupon: Coupon = new Coupon;

  constructor(private http: HttpClient, private shareDataService: ShareDataService) { }

  public chooseApp(option: number) {
    for (let i = 0; i < this.showApp.length; i++) {
      this.showApp[i] = false;
    }
    this.showApp[option] = true;
  }

  public addCoupon(coupon: Coupon): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.baseUrl +
      "addCoupon?t=" + this.shareDataService.userResponse.token,
      coupon);
  }

  public deleteCoupon(): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.baseUrl +
      "deleteCoupon?t=" + this.shareDataService.userResponse.token +
      "&id=" + this.id,
      { withCredentials: true });
  }

  public getAllCoupons(): Observable<UserMessageAndCoupons> {
    return this.http.get<UserMessageAndCoupons>(this.baseUrl +
      "getAllCoupons?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }
  
}
