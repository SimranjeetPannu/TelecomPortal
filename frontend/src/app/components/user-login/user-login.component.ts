import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';
import { User } from 'src/app/models/user.model';
import { AppService } from 'src/app/services/app.service';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  credentials = {email: '', password: ''};
  errorMsg: string = 'Enter youre Email and Password to log in  :)';

  callback(): void {

  }
  constructor(private app: AppService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.app.authenticate(this.credentials)
    // .pipe(catchError(this.handleError))
    .subscribe((data) => {
      this.router.navigateByUrl('/user');
    }, (error:Error)=>{
      this.errorMsg = this.handleError(error);
    });

  }

  handleError(error:any) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      msg = 'Unexpected Error';
    } else {
      msg = 'User Name/Password not found.'
    }
    console.log(msg);
    this.errorMsg! = msg;
    return msg;
  }
}