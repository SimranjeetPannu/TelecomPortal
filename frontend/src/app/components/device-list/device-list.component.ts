import { Component, OnInit } from '@angular/core';
import { Device } from 'src/app/models/device.model';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit {

  devices: Device[] = [];

  constructor(private accountService: AccountService) { }
  
  ngOnInit(): void {
    this.accountService.getDevices()
      .subscribe(response => this.devices = response);
  }
}