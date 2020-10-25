import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  constructor(public companyService: CompanyService, private shareDataService: ShareDataService) { }

  ngOnInit() {
    this.shareDataService.userResponse.message = "";
    this.companyService.message ="";
  }

  public chooseApp(option: number): void {
    this.companyService.chooseApp(option);
  }

  
}
