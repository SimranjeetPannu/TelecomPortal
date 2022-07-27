import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './components/account/account.component';
import { AddDeviceComponent } from './components/add-device/add-device.component';
import { AddPlanComponent } from './components/add-plan/add-plan.component';
import { DeviceDetailComponent } from './components/device-detail/device-detail.component';
import { DeviceListComponent } from './components/device-list/device-list.component';
import { PlanDetailComponent } from './components/plan-detail/plan-detail.component';
import { PlanListComponent } from './components/plan-list/plan-list.component';


const routes: Routes = [
  { path: '', redirectTo: 'account', pathMatch: 'full' },
  { path: 'account', component: AccountComponent },
  // { path: 'account/add-device', component: AddDeviceComponent },
  // { path: 'account/add-plan', component: AddPlanComponent },
  // { path: 'device/:id', component: DeviceDetailComponent },
  { path: 'device', component: DeviceListComponent },
  // { path: 'plan/:id', component: PlanDetailComponent },
  { path: 'phoneplan', component: PlanListComponent },
  // { path: 'account/plan', component: AccountComponent },
  // { path: 'account/device', component: AccountComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
