import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCategoryCouponsComponent } from './view-category-coupons.component';

describe('ViewCategoryCouponsComponent', () => {
  let component: ViewCategoryCouponsComponent;
  let fixture: ComponentFixture<ViewCategoryCouponsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCategoryCouponsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCategoryCouponsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
