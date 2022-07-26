import { TestBed } from '@angular/core/testing';

import { EsbServiceService } from './esb-service.service';

describe('EsbServiceService', () => {
  let service: EsbServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EsbServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
