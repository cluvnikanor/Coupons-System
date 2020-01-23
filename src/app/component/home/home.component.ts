import { Component, OnInit } from '@angular/core';
import { Product } from 'src/models/Product';
import {ProductsService} from  'src/app/services/products.service';
import {LogServiceService} from 'src/app/services/log-service.service';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products:Product[];
  public companies: Company[];

  public constructor(private productsService: ProductsService, private logServiceService: LogServiceService) { }

  ngOnInit() {
    // this.products = this.productsService.getAllProducts();

    // this.productsService.getAllProductsAsync1((productsResults)=>{this.products=productsResults},
    //                                                               (err)=>{console.log(err.message)});    

    this.logServiceService.getAllCompanies().subscribe(c=> {this.companies=c;}, err=> {console.log(err.message)});
  }

}
