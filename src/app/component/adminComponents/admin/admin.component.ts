import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(public adminService: AdminService, private shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.adminService.message = "";
   }

  public chooseApp(option: number): void {
    this.adminService.chooseApp(option);
  }
 
}
