import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  constructor(public companyService: CompanyService) { }

  ngOnInit() {
  }

  public chooseApp(option: number): void {
    this.companyService.chooseApp(option);
  }

  
}
