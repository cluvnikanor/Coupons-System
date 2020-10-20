import { Component, OnInit, Input, Injectable } from '@angular/core';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

// @Injectable({
//   providedIn: 'root'
// })
export class HeaderComponent implements OnInit {
  public currentDate: Date;

  public constructor(public shareDataService: ShareDataService) {
    this.currentDate = new Date();
  }

  ngOnInit() { }

  public chooseApp(option: number): void {
    this.shareDataService.chooseApp(option);
  }

  // public login(): void {
  //   if (this.shareDataService.showLogin) {
  //     this.shareDataService.showLogin = false;
  //   } else {
  //     this.shareDataService.showLogin = true;
  //     this.shareDataService.showAdmin = false;
  //     this.shareDataService.showCompany = false;
  //     this.shareDataService.showCustomer = false;
  //   }
  // }

  // public admin(): void {
  //   this.shareDataService.admin();
  // }

  // public company(): void {
  //   this.shareDataService.company();
  // }

  // public customer(): void {
  //   this.shareDataService.customer();
  // }

}
