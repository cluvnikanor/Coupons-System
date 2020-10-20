import { Component, OnInit } from '@angular/core';
import {ShareDataService} from 'src/app/services/share-data.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  public constructor(public shareDataService: ShareDataService) { }

  ngOnInit() {}


}
