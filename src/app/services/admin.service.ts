import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from 'src/models/company';
import { UserMessage } from 'src/models/user-message';
import { UserMessageAndCompanies } from 'src/models/user-message-and-companies';
import { UserMessageAndCompany } from 'src/models/user-message-and-company';
import { UserMessageAndCustomer } from 'src/models/user-message-and-customer';
import { UserMessageAndCustomers } from 'src/models/user-message-and-customers';
import { ShareDataService } from './share-data.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl = "http://localhost:8080/admin/"
  public message: string = "";
  public email: string = "";
  public newEmail: string = "";
  public password: string = "";
  public showApp: boolean[] = [false, false, false, false, false, false, false, false, false, false, false];

  constructor(private http: HttpClient, private shareDataService: ShareDataService) { }

  public chooseApp(option: number) {
    for (let i = 0; i < this.showApp.length; i++) {
      this.showApp[i] = false;
    }
    this.showApp[option] = true;
  }

  public addCompany(Company): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.baseUrl +
      "addCompany?t=" + this.shareDataService.userResponse.token,
      Company);
  }

  public updateCompany(): Observable<UserMessage> {
    return this.http.put<UserMessage>(this.baseUrl +
      "updateCompany?t=" + this.shareDataService.userResponse.token +
      "&existEmail=" + this.email +
      "&newEmail=" + this.newEmail +
      "&newPassword=" + this.password,
      { withCredentials: true });
  }

  public deleteCompany(): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.baseUrl +
      "deleteCompany?t=" + this.shareDataService.userResponse.token +
      "&email=" + this.email,
      { withCredentials: true });
  }

  public getCompany(): Observable<UserMessageAndCompany> {
    return this.http.get<UserMessageAndCompany>(this.baseUrl +
      "getCompany?t=" + this.shareDataService.userResponse.token +
      "&email=" + this.email,
      { withCredentials: true });
  }

  public getAllCompanies(): Observable<UserMessageAndCompanies> {
    return this.http.get<UserMessageAndCompanies>(this.baseUrl +
      "getAllCompanies?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }

  public addCustomer(Customer): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.baseUrl +
      "addCustomer?t=" + this.shareDataService.userResponse.token,
      Customer);
  }

  public updateCustomer(): Observable<UserMessage> {
    return this.http.put<UserMessage>(this.baseUrl +
      "updateCustomer?t=" + this.shareDataService.userResponse.token +
      "&existEmail=" + this.email +
      "&newEmail=" + this.newEmail +
      "&newPassword=" + this.password,
      { withCredentials: true });
  }

  public deleteCustomer(): Observable<UserMessage> {
    return this.http.post<UserMessage>(this.baseUrl +
      "deleteCustomer?t=" + this.shareDataService.userResponse.token +
      "&email=" + this.email,
      { withCredentials: true });
  }

  public getCustomer(): Observable<UserMessageAndCustomer> {
    return this.http.get<UserMessageAndCustomer>(this.baseUrl +
      "getCustomer?t=" + this.shareDataService.userResponse.token +
      "&email=" + this.email,
      { withCredentials: true });
  }

  public getAllCustomers(): Observable<UserMessageAndCustomers> {
    return this.http.get<UserMessageAndCustomers>(this.baseUrl +
      "getAllCustomers?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }

}
