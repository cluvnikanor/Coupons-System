import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserResponse } from 'src/models/user-response';
import { ShareDataService } from './share-data.service';
import { Company } from 'src/models/company';
import { Customer } from 'src/models/customer';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public customerIsLoged: boolean = false;

  private baseUrl = "/"
  // private baseUrl = "http://localhost:8080/"
  email: string = "";
  password: string = "";
  type: string = "";
  token: string = "";
  company: Company = new Company;
  customer: Customer= new Customer;

  constructor(private http: HttpClient, public shareDataService: ShareDataService) { }

  public login(): Observable<UserResponse> {
    return this.http.get<UserResponse>(this.baseUrl + "login?type=" + this.type
      + "&email=" + this.email + "&password=" + this.password,
      { withCredentials: true });
  }

  public logout(): Observable<UserResponse> {
    return this.http.get<UserResponse>(this.baseUrl + "logout?t=" + this.shareDataService.userResponse.token,
      { withCredentials: true });
  }

  public companyRegister(company: Company): Observable<UserResponse> {
    return this.http.post<UserResponse>(this.baseUrl + "companyRegister", company);
  }

  public customerRegister(customer: Customer): Observable<UserResponse> {
    return this.http.post<UserResponse>(this.baseUrl + "customerRegister", customer);
  }

}
