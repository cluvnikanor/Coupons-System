import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCompanyCouponsComponent } from './view-company-coupons.component';

describe('ViewAllCouponsComponent', () => {
  let component: ViewCompanyCouponsComponent;
  let fixture: ComponentFixture<ViewCompanyCouponsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCompanyCouponsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCompanyCouponsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
