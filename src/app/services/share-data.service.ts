import { Injectable } from '@angular/core';
import { UserResponse } from 'src/models/user-response';

@Injectable({
  providedIn: 'root'
})
export class ShareDataService {

  public showApp: boolean[] = [false, false, false, false, false];
  public userResponse = new UserResponse();

  constructor() { }

  chooseApp(option: number) {
    for (let i=0; i<this.showApp.length; i++){
      this.showApp[i] = false;
    }
    this.showApp[option] = true;
  }

}
