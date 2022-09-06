import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './models/user.model';
import { UserStateService } from './services/user-state.service';
import { LogoutService } from './services/logout.service';
import { AppService } from './services/app.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  credentials = {email: '', password: ''}
  title = 'Skillstorm-P2';//has to match server
  User?: User;
  userId = JSON.parse(sessionStorage.getItem('userId') || '{}');


  constructor(private app: AppService, private userStateService: UserStateService, private logoutService: LogoutService, private http: HttpClient, private router: Router){

  }

  ngOnInit(): void {
    this.userStateService.currentUser.subscribe(user => this.User = user)
  }

  typeOf(any: any){
    return typeof(any);
  }

  logout() {
    this.logoutService.logout(
    ).subscribe((data)=>{


    });
    sessionStorage.clear();
    this.router.navigateByUrl('/landing', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/login']);
  });
  }
}