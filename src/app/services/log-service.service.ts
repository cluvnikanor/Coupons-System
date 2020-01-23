import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Company } from 'src/models/company';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogServiceService {
  public isLoged:boolean = false;

  private url="http://localhost:8080/company/getAll"

  constructor(private http:HttpClient) { }

  public loginButtonClicked(): void {
    this.isLoged = true;
    //return this.http.get<company[]>(this.url).subscribe(()=>{}); 
  }

  public getAllCompanies():Observable<Company[]>{
    return this.http.get<Company[]>(this.url, {withCredentials: true});
  }
}
