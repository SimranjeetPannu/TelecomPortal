import { Component, OnInit } from '@angular/core';
import { Plan } from 'src/app/models/plan.model';
import { AccountService } from 'src/app/services/account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plan-list',
  templateUrl: './plan-list.component.html',
  styleUrls: ['./plan-list.component.css']
})

export class PlanListComponent implements OnInit {

  plans: Plan[] = [];

  constructor(private accountService: AccountService) { }
  
  ngOnInit(): void {
    this.accountService.getPlans()
      .subscribe(response => this.plans = response);
  }

//   planList?: Plan[];
//   currentPlan: Plan = {};
//   currentIndex = -1;
//   planName = '';

//   constructor(private accountService: AccountService, private router: Router) { }
  
//   ngOnInit(): void {
//     this.retrievePlan();
//   }

//   retrievePlan(): void {
//     this.accountService.getAllPlan()
//       .subscribe({
//         next: (data) => {
//           this.planList = data;
//           console.log(data);
//         },
//         error: (e) => console.error(e)
//       });
//   }

//   refreshList(): void {
//     this.retrievePlan();
//     this.currentPlan = {};
//     this.currentIndex = -1;
//   }

//   setActivePlan(plan: Plan, index: number): void {
//     this.currentPlan = plan;
//     this.currentIndex = index;
//   }

// }}
}
