/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TravelExpenseDetailService } from './travel-expense-detail.service';

describe('TravelExpenseDetailService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TravelExpenseDetailService]
    });
  });

  it('should ...', inject([TravelExpenseDetailService], (service: TravelExpenseDetailService) => {
    expect(service).toBeTruthy();
  }));
});
