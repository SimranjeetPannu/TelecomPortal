import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserStateService {

  thisUser?: User;
  private UserSource = new BehaviorSubject<User>(this.thisUser!)
  currentUser = this.UserSource.asObservable();
  
  constructor() { }

  getUser() {
    return this.currentUser;
  }

  resetUser() {
    this.UserSource.next({id:0,userName:"",email:"",password:""})
  }

  changeUser(user: User) {
    this.UserSource.next(user);
  }
}