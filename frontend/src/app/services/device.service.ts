import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Device } from '../models/device.model';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  url: string = environment.apiUrl+"/devices"; //dunno yet
  constructor(private http: HttpClient) { }

  findAllDevices(): Observable<HttpResponse<Device[]>> {
    return this.http.get<Device[]>(this.url + "/authed", {observe: 'response', withCredentials: true});
  }

  findDevicesByPlan(planid: number): Observable<HttpResponse<Device[]>> {
    return this.http.get<Device[]>(this.url + `/${planid}`, {observe: 'response', withCredentials: true});
  }

  findDeviceById(deviceId: number): Observable<HttpResponse<Device>> {
    return this.http.get<Device>(this.url + `/${deviceId}`, {observe: 'response', withCredentials: true});
  }

  saveDevice(device: Device): Observable<HttpResponse<Device>> {
    return this.http.post<Device>(this.url + "/newdevice", device, {observe: 'response', withCredentials: true});
  }

  updateDevice(device: Device, deviceId: number): Observable<HttpResponse<Device>> {
    return this.http.put<Device>(this.url + `/update/${deviceId}`, device, {observe: 'response', withCredentials: true});
  }

  deleteDevice(id: number): Observable<HttpResponse<Device>> {
    return this.http.delete<Device>(this.url + '/' + id, {observe: 'response', withCredentials: true});
  }

}