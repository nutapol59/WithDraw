/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FormWithDrawComponent } from './form-with-draw.component';

describe('FormWithDrawComponent', () => {
  let component: FormWithDrawComponent;
  let fixture: ComponentFixture<FormWithDrawComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormWithDrawComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormWithDrawComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
