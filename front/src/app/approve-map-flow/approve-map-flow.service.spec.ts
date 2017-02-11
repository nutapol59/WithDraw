/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ApproveMapFlowService } from './approve-map-flow.service';

describe('ApproveMapFlowService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApproveMapFlowService]
    });
  });

  it('should ...', inject([ApproveMapFlowService], (service: ApproveMapFlowService) => {
    expect(service).toBeTruthy();
  }));
});
