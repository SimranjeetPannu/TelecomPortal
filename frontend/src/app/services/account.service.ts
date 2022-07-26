import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Device } from '../models/device.model';
import { Plan } from '../models/plan.model';
import { Account } from '../models/account.model';


@Injectable({
  providedIn: 'root'
})

export class AccountService {

  url: string = 'http://localhost:8080';


  constructor(private http: HttpClient) { }

  getPlans(): Observable<Plan[]>{
    return this.http.get<Plan[]>(this.url + '/phoneplan/');
  }

  getDevices(): Observable<Device[]>{
    return this.http.get<Device[]>(this.url + '/devices/v1/');
  }

  //get list of all devices
  // getAllDevice(): Observable<Device[]> {
  //   return this.http.get<Device[]>('http://localhost:8080/device');
  // }

  //get list of all plans
  // getAllPlan(): Observable<Plan[]> {
  //   return this.httpClient.get<Plan[]>('http://localhost:8080/plan/');
  // }

  //get detail of specific device
  // getDeviceDetail(id: any): Observable<Device> {
  //   return this.http.get<Device>(`${'http://localhost:8080/device'}/${id}`);
  // }

  //get detail of specific plan
  // getPlanDetail(id: any): Observable<Plan> {
  //   return this.http.get<Plan>(`${'http://localhost:8080/plan'}/${id}`);
  // }

  //get details of account
  // getAccountDetail(customerId: any): Observable<Account> {
  //   return this.http.get<Account>('http://localhost:8080/account')
  // }

  //add a plan to account(???)
  // addPlan(id: any): Observable<Plan> {
  //   return this.http.post<Plan>('http://localhost:8080/account/add-plan', `${'http://localhost:8080/plan'}/${id}`);
  // }

  //add a device to account(???)
  // addDevice(id: any): Observable<Device> {
  //   return this.http.post<Device>('http://localhost:8080/account/add-device', `${'http://localhost:8080/device'}/${id}`);
  // }

  //delete a plan from account(???)
  // deletePlan(id: any): Observable<Plan> {
  //   return this.http.delete<Plan>(`${'http://localhost:8080/plan'}/${id}`);
  // }

  //delete a device from account(???)
  // deleteDevice(id: any): Observable<Device> {
  //   return this.http.delete<Device>(`${'http://localhost:8080/device'}/${id}`);
  // }
  
}
