import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(public adminService: AdminService) { }

  ngOnInit() { }

  public chooseApp(option: number): void {
    this.adminService.chooseApp(option);
  }
 
}
