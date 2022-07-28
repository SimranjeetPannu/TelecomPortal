import { Component } from '@angular/core';
import { UserInfo } from './services/google-auth.service';
import { GoogleAuthService } from './services/google-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'SpringStorm';
  userInfo?: UserInfo

  constructor(private readonly googleAuth: GoogleAuthService) {
    googleAuth.userProfileSubject.subscribe( info => {
      this.userInfo = info
    })
  }

  isLoggedIn(): boolean {
    return this.googleAuth.isLoggedIn()
  }

  logout() {
    this.googleAuth.signOut()
  }
}
