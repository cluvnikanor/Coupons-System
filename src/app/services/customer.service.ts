import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ShareDataService } from './share-data.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseUrl = "http://localhost:8080/customer/"
  public showApp: boolean[] = [false, false, false, false, false, false, false, false, false, false, false];
  public message: string = "";

  constructor(private http: HttpClient, private shareDataService: ShareDataService) { }
}
