import { Component, OnInit } from '@angular/core';
import {LogServiceService} from 'src/app/services/log-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
  constructor(public logServiceService: LogServiceService) { 
    
  }

  ngOnInit() {
  }

}
