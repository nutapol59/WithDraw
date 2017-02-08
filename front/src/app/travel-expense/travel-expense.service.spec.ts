/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TravelExpenseService } from './travel-expense.service';

describe('TravelExpenseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TravelExpenseService]
    });
  });

  it('should ...', inject([TravelExpenseService], (service: TravelExpenseService) => {
    expect(service).toBeTruthy();
  }));
});
