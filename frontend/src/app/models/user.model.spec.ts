import { User } from './user.model';

describe('User', () => {
  it('should create an instance', () => {
    expect(new User("Simran","spannu@gmail.com", "happy203")).toBeTruthy();
  });
});