import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPricesCouponsComponent } from './view-prices-coupons.component';

describe('ViewPricesCouponsComponent', () => {
  let component: ViewPricesCouponsComponent;
  let fixture: ComponentFixture<ViewPricesCouponsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPricesCouponsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPricesCouponsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
