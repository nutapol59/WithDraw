/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ConfigModeServerService } from './config-mode-server.service';

describe('ConfigModeServerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConfigModeServerService]
    });
  });

  it('should ...', inject([ConfigModeServerService], (service: ConfigModeServerService) => {
    expect(service).toBeTruthy();
  }));
});
