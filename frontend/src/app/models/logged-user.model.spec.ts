import { LoggedUser } from './logged-user.model';

describe('LoggedUser', () => {
  it('should create an instance', () => {
    expect(new LoggedUser("Zulmak","zulmak@destiny2.com","zulmak",[],[])).toBeTruthy();
  });
});