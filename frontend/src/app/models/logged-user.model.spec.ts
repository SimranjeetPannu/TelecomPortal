import { LoggedUser } from './logged-user.model';

describe('LoggedUser', () => {
  it('should create an instance', () => {
    expect(new LoggedUser("Dan Pickles","pickleman@gmail.com","pickles",[],[])).toBeTruthy();
  });
});