/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ListSentApproveComponent } from './list-sent-approve.component';

describe('ListSentApproveComponent', () => {
  let component: ListSentApproveComponent;
  let fixture: ComponentFixture<ListSentApproveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListSentApproveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSentApproveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
