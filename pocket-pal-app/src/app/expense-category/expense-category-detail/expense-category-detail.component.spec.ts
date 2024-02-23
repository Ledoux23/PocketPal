import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseCategoryDetailComponent } from './expense-category-detail.component';

describe('ExpenseCategoryDetailComponent', () => {
  let component: ExpenseCategoryDetailComponent;
  let fixture: ComponentFixture<ExpenseCategoryDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExpenseCategoryDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExpenseCategoryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
