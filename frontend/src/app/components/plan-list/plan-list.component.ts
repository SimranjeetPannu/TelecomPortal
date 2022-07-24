import { Component, OnInit } from '@angular/core';
import { Plan } from 'src/app/models/plan.model';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-plan-list',
  templateUrl: './plan-list.component.html',
  styleUrls: ['./plan-list.component.css']
})
export class PlanListComponent implements OnInit {
  plan?: Plan[];
  currentPlan: Plan = {};
  currentIndex = -1;
  planName = '';

  constructor(private accountService: AccountService) { }
  
  ngOnInit(): void {
    this.retrievePlan();
  }

  retrievePlan(): void {
    this.accountService.getAllPlan()
      .subscribe({
        next: (data) => {
          this.plan = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  refreshList(): void {
    this.retrievePlan();
    this.currentPlan = {};
    this.currentIndex = -1;
  }

  setActivePlan(plan: Plan, index: number): void {
    this.currentPlan = plan;
    this.currentIndex = index;
  }

}
