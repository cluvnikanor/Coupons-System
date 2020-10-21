import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CouponPurchaseComponent } from './coupon-purchase.component';

describe('CouponPurchaseComponent', () => {
  let component: CouponPurchaseComponent;
  let fixture: ComponentFixture<CouponPurchaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CouponPurchaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CouponPurchaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
