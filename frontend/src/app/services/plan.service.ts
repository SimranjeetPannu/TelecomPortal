import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PhonePlan } from '../models/plan.model';

@Injectable({
  providedIn: 'root'
})
export class PlanService {
  url: string = environment.apiUrl+"/plans"; //dunno yet
  constructor(private http: HttpClient) { }

  findAllPlans(): Observable<HttpResponse<PhonePlan[]>> {
    return this.http.get<PhonePlan[]>(this.url + "/authed", {observe: 'response', withCredentials: true});
  }

  findPlansByUser(customerid: number): Observable<HttpResponse<PhonePlan[]>> {
    return this.http.get<PhonePlan[]>(this.url + `/${customerid}`, {observe: 'response', withCredentials: true});
  }

  findPlanById(planid: number): Observable<HttpResponse<PhonePlan>> {
    return this.http.get<PhonePlan>(this.url + `/plan/${planid}`, {observe: 'response', withCredentials: true});
  }

  findLatestPlan(): Observable<HttpResponse<PhonePlan>> {
    return this.http.get<PhonePlan>(this.url + `/latestplan`, {observe: 'response', withCredentials: true});
  }

  savePlan(plan: PhonePlan): Observable<HttpResponse<PhonePlan>> {
    return this.http.post<PhonePlan>(this.url + "/newplan", plan, {observe: 'response', withCredentials: true});
  }

  updatePlan(plan: PhonePlan): Observable<HttpResponse<PhonePlan>> {
    return this.http.put<PhonePlan>(this.url + `/update/${plan.id}`, plan, {observe: 'response', withCredentials: true});
  }

  deletePlan(id: number): Observable<HttpResponse<PhonePlan>> {
    return this.http.delete<PhonePlan>(this.url + '/' + id, {observe: 'response', withCredentials: true});
  }

}