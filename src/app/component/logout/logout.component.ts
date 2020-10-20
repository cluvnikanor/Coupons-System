import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { UserResponse } from 'src/models/user-response';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  // public userResponse = new UserResponse();

  constructor(public loginService: LoginService, public shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
  }

  public logout(): void {
    this.loginService.token = this.shareDataService.userResponse.token;
    this.loginService.logout().subscribe(c => { this.shareDataService.userResponse = c; },
      err => { console.log(err.message) });
    this.shareDataService.showApp[0];
  }

}
