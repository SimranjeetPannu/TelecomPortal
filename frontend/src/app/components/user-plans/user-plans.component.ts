import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { Device } from 'src/app/models/device.model';
import { PhonePlan } from 'src/app/models/plan.model';
import { User } from 'src/app/models/user.model';
import { DeviceService } from 'src/app/services/device.service';
import { PlanService } from 'src/app/services/plan.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-users-plans',
  templateUrl: './user-plans.component.html',
  styleUrls: ['./user-plans.component.css']
})
export class UsersPlansComponent implements OnInit {
  Plans: PhonePlan[] = [];
  Devices?: Device[] = [];



  @Input() User?: User;
  TotalCost: number = 0;

  constructor(private planService: PlanService, private deviceService: DeviceService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {

    this.userService.findUser().subscribe(data => {
      if (data.body != null)
      sessionStorage.setItem('customerid', data.body?.id.toString());

      this.planService.findPlansByUser(JSON.parse(sessionStorage.getItem('customerid') || '{}')).subscribe((data) => {
        if (data.body != null) {
          this.Plans = data.body;
          for(let i = 0; i < this.Plans.length; i++){
            this.TotalCost += this.Plans[i].price;
          }
          for (let i = 0; i < this.Plans.length; i++) {
            this.deviceService.findDevicesByPlan(this.Plans[i].id).subscribe((data) => {
              if (data.body != null) {
                this.Devices = data.body;
              }
            });
          }

        }

      });

    })
  };

  deletePlan(id: number): void {
    this.planService.deletePlan(id).subscribe((data) => {
      this.router.navigateByUrl('/landing', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/user']);
    });
    });
  }

  redirect() {
    this.router.navigateByUrl('/planCreation');
  }

}