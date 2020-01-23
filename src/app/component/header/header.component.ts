import { Component, OnInit, Input } from '@angular/core';
import { LogServiceService } from 'src/app/services/log-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {
  public currentDate: Date;


  constructor(public logServiceService: LogServiceService) { 
    this.currentDate = new Date();
  }

  ngOnInit() {
  }
  
}
