import { Component, OnInit } from '@angular/core';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public shareDataService: ShareDataService) { }

  ngOnInit() {
  }

}
