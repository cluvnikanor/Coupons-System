import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coupon } from 'src/models/coupon';
import { UserMessage } from 'src/models/user-message';
import { UserMessageAndCoupons } from 'src/models/user-message-and-coupons';
import { UserMessageAndCustomer } from 'src/models/user-message-and-customer';
import { ShareDataService } from './share-data.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseUrl = "/customer/"
  // private baseUrl = "http://localhost:8080/customer/"
  public showApp: boolean[] = [false, false, false, false, false, false, false, false, false, false, false];
  public message: string = "";
  public couponId: number = 0;

  constructor(private http: HttpClient, private shareDataService: ShareDataService) { }

  public chooseApp(option: number) {
    for (let i = 0; i < this.showApp.length; i++) {
      this.showApp[i] = false;
    }
    this.showApp[option] = true;
  }

  public couponPurchase(): Observable<UserMessage> {
    return this.http.put<UserMessage>(this.baseUrl +
      "couponPurchase?t=" + this.shareDataService.userResponse.token + 
      "&couponId=" + this.couponId,
      { withCredentials: true });
  }

  public getCustomerCoupons(): Observable<UserMessageAndCoupons> {
    return this.http.get<UserMessageAndCoupons>(this.baseUrl +
      "getCustomerCoupons?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }

  public getAllCoupons(): Observable<UserMessageAndCoupons> {
    return this.http.get<UserMessageAndCoupons>(this.baseUrl +
      "getAllCoupons?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }

  public getCustomerDetails(): Observable<UserMessageAndCustomer> {
    return this.http.get<UserMessageAndCustomer>(this.baseUrl +
      "getCustomerDetails?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }

}
