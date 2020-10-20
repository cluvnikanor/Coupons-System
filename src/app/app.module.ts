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
import { LogoutComponent } from './component/logout/logout.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerComponent } from './component/customerComponents/customer/customer.component';
import { AdminComponent } from './component/adminComponents/admin/admin.component';
import { CompanyComponent } from './component/companyComponents/company/company.component';
import { AddCompanyComponent } from './component/adminComponents/add-company/add-company.component';
import { UpdateCompanyComponent } from './component/adminComponents/update-company/update-company.component';
import { DeleteCompanyComponent } from './component/adminComponents/delete-company/delete-company.component';
import { ViewCompanyComponent } from './component/adminComponents/view-company/view-company.component';
import { ViewAllCompaniesComponent } from './component/adminComponents/view-all-companies/view-all-companies.component';
import { AddCustomerComponent } from './component/adminComponents/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './component/adminComponents/update-customer/update-customer.component';
import { DeleteCustomerComponent } from './component/adminComponents/delete-customer/delete-customer.component';
import { ViewCustomerComponent } from './component/adminComponents/view-customer/view-customer.component';
import { ViewAllCustomersComponent } from './component/adminComponents/view-all-customers/view-all-customers.component';
import { AddCouponComponent } from './component/companyComponents/add-coupon/add-coupon.component';
import { UpdateCouponComponent } from './component/companyComponents/update-coupon/update-coupon.component';
import { DeleteCouponComponent } from './component/companyComponents/delete-coupon/delete-coupon.component';
import { ViewAllCouponsComponent } from './component/companyComponents/view-all-coupons/view-all-coupons.component';
import { ViewCategoryCouponsComponent } from './component/companyComponents/view-category-coupons/view-category-coupons.component';
import { ViewPricesCouponsComponent } from './component/companyComponents/view-prices-coupons/view-prices-coupons.component';
import { ViewCompanyDetailsComponent } from './component/companyComponents/view-company-details/view-company-details.component';
 
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    MenuComponent,
    AboutComponent, 
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    CustomerComponent,
    AdminComponent,
    CompanyComponent,
    AddCompanyComponent,
    UpdateCompanyComponent,
    DeleteCompanyComponent,
    ViewCompanyComponent,
    ViewAllCompaniesComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    DeleteCustomerComponent,
    ViewCustomerComponent,
    ViewAllCustomersComponent,
    AddCouponComponent,
    UpdateCouponComponent,
    DeleteCouponComponent,
    ViewAllCouponsComponent,
    ViewCategoryCouponsComponent,
    ViewPricesCouponsComponent,
    ViewCompanyDetailsComponent,
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
