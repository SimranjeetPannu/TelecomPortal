import { PhonePlan } from './plan.model';

describe('Plan', () => {
  it('should create an instance', () => {
    expect(new PhonePlan("Plan1", 5, 120.99, 1)).toBeTruthy();
  });
});