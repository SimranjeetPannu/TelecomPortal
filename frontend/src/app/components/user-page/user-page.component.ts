import { outputAst } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from 'src/app/models/device.model';
import { User } from 'src/app/models/user.model';
import { UserStateService } from 'src/app/services/user-state.service';
import { DeviceService } from 'src/app/services/device.service';
import { PlanService } from 'src/app/services/plan.service';
import { AppService } from 'src/app/services/app.service';
import { UserService } from 'src/app/services/user.service';
import { PhonePlan } from 'src/app/models/plan.model';


@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  //not sure how to do with login so I'm gonna wait on this one
  User?: User;
  Plans: PhonePlan[] = [];
  Devices?: Device[]=[];
  Device: Device | undefined;
  // User.id: number;

  constructor(private userService: UserService, private planService: PlanService, private deviceService: DeviceService, private userStateService: UserStateService, private router: Router) { }

  ngOnInit(): void {

    this.userService.findUser().subscribe((data)=>{
      if (data.body != null) {
        // console.log(data.body);
        
        sessionStorage.setItem('customerid', data.body.id.toString()); 
        //STUFF WITH DATA HERE
        this.User = data.body;
        this.userStateService.changeUser(this.User)
      }
    })

}
}