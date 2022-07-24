import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPlanComponent } from './components/add-plan/add-plan.component';
import { PlanDetailComponent } from './components/plan-detail/plan-detail.component';
import { PlanListComponent } from './components/plan-list/plan-list.component';
import { AddDeviceComponent } from './components/add-device/add-device.component';
import { DeviceDetailComponent } from './components/device-detail/device-detail.component';
import { DeviceListComponent } from './components/device-list/device-list.component';
import { AccountComponent } from './components/account/account.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'


@NgModule({
  declarations: [
    AppComponent,
    AddPlanComponent,
    PlanDetailComponent,
    PlanListComponent,
    AddDeviceComponent,
    DeviceDetailComponent,
    DeviceListComponent,
    AccountComponent,
    FormsModule,
    HttpClientModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
