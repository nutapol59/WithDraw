/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { BankService } from './bank.service';

describe('BankService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BankService]
    });
  });

  it('should ...', inject([BankService], (service: BankService) => {
    expect(service).toBeTruthy();
  }));
});
