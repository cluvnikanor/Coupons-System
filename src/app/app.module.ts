import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { bootstrap} from "bootstrap";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { MenuComponent } from './component/menu/menu.component';
import { AboutComponent } from './component/about/about.component';
import { HomeComponent } from './component/home/home.component';
import { HeaderComponent } from './component/header/header.component';
import { LoginComponent } from './component/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerComponent } from './component/customerComponents/customer/customer.component';
import { AdminComponent } from './component/adminComponents/admin/admin.component';
import { CompanyComponent } from './component/companyComponents/company/company.component';
import { ViewAllCompaniesComponent } from './component/adminComponents/view-all-companies/view-all-companies.component';
import { ViewAllCustomersComponent } from './component/adminComponents/view-all-customers/view-all-customers.component';
import { ViewCompanyCouponsComponent } from './component/companyComponents/view-company-coupons/view-company-coupons.component';
import { ViewCompanyDetailsComponent } from './component/companyComponents/view-company-details/view-company-details.component';
import { ViewCustomerCouponsComponent } from './component/customerComponents/view-customer-coupons/view-customer-coupons.component';
import { ViewCustomerDetailsComponent } from './component/customerComponents/view-customer-details/view-customer-details.component';
import { CouponPurchaseComponent } from './component/customerComponents/coupon-purchase/coupon-purchase.component';
 
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    MenuComponent,
    AboutComponent, 
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    CustomerComponent,
    AdminComponent,
    CompanyComponent,
    ViewAllCompaniesComponent,
    ViewAllCustomersComponent,
    ViewCompanyCouponsComponent,
    ViewCompanyDetailsComponent,
    ViewCompanyCouponsComponent,
    ViewCustomerCouponsComponent,
    ViewCustomerDetailsComponent,
    CouponPurchaseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    // HeaderComponent,
    // HomeComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
