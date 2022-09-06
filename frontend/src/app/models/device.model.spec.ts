import { Device } from './device.model';

describe('Device', () => {
  it('should create an instance', () => {
    expect(new Device("Device1", "6453748875", 1)).toBeTruthy();
  });
});