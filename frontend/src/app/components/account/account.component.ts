import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/models/account.model';
import { User } from 'src/app/models/user.model';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  //  account: Account = new Account();
   user: User = new User();

  constructor(private accountService: AccountService) { }
  
  ngOnInit(): void {
    // remove
    // this.accountService.getAccountDetails()
    //   .subscribe(response => this.account = response);
    this.accountService.getUserDetails()
      .subscribe(response => this.user = response);
  }
}