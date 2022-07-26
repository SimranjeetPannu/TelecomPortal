import { LiteralMapExpr } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from 'src/app/models/device.model';
import { PhonePlan } from 'src/app/models/plan.model';
import { User } from 'src/app/models/user.model';
import { DeviceService } from 'src/app/services/device.service';
import { PlanService } from 'src/app/services/plan.service';
import { UserStateService } from 'src/app/services/user-state.service';



@Component({
  selector: 'app-plan-page',
  templateUrl: './plan-page.component.html',
  styleUrls: ['./plan-page.component.css']
})
export class PlanPageComponent implements OnInit {
  customerid = JSON.parse(sessionStorage.getItem('customerid') || '{}');
  Plan: PhonePlan = new PhonePlan("noplan", 0, 0.0, this.customerid);
  mimtPlan: string = "noplan";
  phones: string[] = [""];
  errorMsg: string = '';
  dup: boolean = false;
  warningMsg: string = '';

  selected: boolean = false;

  constructor(private planService: PlanService, private deviceService: DeviceService, private router: Router) { }

  typeOf(any: any) {
    return typeof (any);
  }

  incr() {
    let curPhones = document.getElementById("curPhones");
    let maxPhones = document.getElementById("maxPhones");
    if (curPhones && maxPhones) {
      if (Number(curPhones.innerHTML) < Number(maxPhones.innerHTML)) {
        curPhones.innerHTML = String(Number(curPhones.innerHTML) + 1);
        this.phones.push("");
      }
    }
  }
  decr() {
    let curPhones = document.getElementById("curPhones");
    if (curPhones) {
      if (this.phones.length > 1) {
        curPhones.innerHTML = String(Number(curPhones.innerHTML) - 1);
        this.phones.pop();
      }

    }
  }

  selectPlan(p: string) {
    var plan1 = document.getElementById("plan1");
    var plan2 = document.getElementById("plan2");
    var plan3 = document.getElementById("plan3");
    if (p == 'YELLOW PLAN') {
      this.mimtPlan = 'YELLOW PLAN';
      plan1?.classList.add('selected');
      this.selected = true;
      let curPhones = document.getElementById("curPhones");
      let maxPhones = document.getElementById("maxPhones");
      if (curPhones && maxPhones) {
        maxPhones.innerHTML = "2";
        curPhones.innerHTML = "2";

      }
      while (this.phones.length > 1) {
        this.phones.pop();
      }
      this.Plan.planName = "Yellow Plan";
      this.Plan.price = 31.45;
      this.Plan.deviceLimit = 2;
    }
    else {
      plan1?.classList.remove('selected');
    }
    if (p == 'BASIC') {
      this.mimtPlan = 'BASIC';
      plan2?.classList.add('selected');
      this.selected = true;
      let curPhones = document.getElementById("curPhones");
      let maxPhones = document.getElementById("maxPhones");
      if (curPhones && maxPhones) {
        maxPhones.innerHTML = "5";

        while (this.phones.length > 4) {
          this.phones.pop();
          curPhones.innerHTML = "4";
        }
      }
      this.Plan.planName = "Basic";
      this.Plan.price = 65.76;
      this.Plan.deviceLimit = 4;
    }
    else {
      plan2?.classList.remove('selected');
    }
    if (p == 'ULTRA') {
      this.mimtPlan = 'ULTRA';
      plan3?.classList.add('selected');
      this.selected = true;
      let curPhones = document.getElementById("curPhones");
      let maxPhones = document.getElementById("maxPhones");
      if (curPhones && maxPhones) {

        maxPhones.innerHTML = "8";

      }
      this.Plan.planName = "Ultra";
      this.Plan.price = 124.36;
      this.Plan.deviceLimit = 8;
    }
    else {
      plan3?.classList.remove('selected');
    }

    this.selected = true;
  }
  submitPlan() {
    let Devices: Device[] = [];
    if (!this.dup) {
      let phoneDiv = document.querySelectorAll('[id=phone]');
      let phoneNumbers = [];
      let modelDiv = document.querySelectorAll('[id=model]');
      let models = [];

      for (let i = 0; i < phoneDiv.length; i++) {
        if ((phoneDiv[i] as HTMLInputElement).value == "") {
          alert("compleate phone number input");
          return;
        }
        phoneNumbers.push((phoneDiv[i] as HTMLInputElement).value);

        if ((modelDiv[i] as HTMLInputElement).value == "") {
          alert("compleate model input");
          return;
        }
        models.push((modelDiv[i] as HTMLInputElement).value);
        Devices.push(new Device((modelDiv[i] as HTMLInputElement).value, (phoneDiv[i] as HTMLInputElement).value, this.Plan.id))
      }
        if (this.mimtPlan == "noplan") {
          alert('please select a plan');
        }
        else {

          if (this.selected === true) {


            try {
              this.planService.savePlan(this.Plan).subscribe(data => {
                if (data.body != null || data.body != undefined) {
                  this.Plan = data.body
                }

                for (let i = 0; i < Devices.length; i++) {
                  Devices[i].planid = this.Plan.id
                  this.deviceService.saveDevice(Devices[i]).subscribe(data => {
                    setTimeout(() => this.router.navigateByUrl('/user'), 2500);
                  }, (error: Error) => {
                    this.errorMsg = this.handleError(error);
                  })
                }


              });
            } catch (e) {
              console.log("error")
            }



          }

        }




        //////////////////////////////////////////////////////////////
        //  This is where a new plan request is sent to database    //
        //  plan name is in this.mimtPlan                           //
        //  phone nums and phone models are in parallel arrays      //
        //  there is no validation other than checking for ""       //
        //  and making sure a plan is selected                      //
        //////////////////////////////////////////////////////////////



    }
  }

  ngOnInit(): void {
    this.planService.findPlansByUser(this.customerid).subscribe((data) => {
      // logs all plans for current user
      // console.log(data.body);
      if (data.body != null) {
        //this.Plan = data.body;
      }
    });
  }

  handleError(error: any) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      msg = 'Unexpected Error';
    } else {
      msg = 'ERROR: Phone number(s) already tied to a different plan.'
    }
    console.log(msg);
    this.errorMsg! = msg;
    return msg;
  }

  changeHandler() {
    let phoneDiv = document.querySelectorAll('[id=phone]');
    let phoneNumbers: string[] = [];

    for (let i = 0; i < phoneDiv.length; i++) {
      if ((phoneDiv[i] as HTMLInputElement).value != '') {
        phoneNumbers.push((phoneDiv[i] as HTMLInputElement).value);
      }
    }

    let dup = false;
    dup = phoneNumbers.some((element, index) => {
      return phoneNumbers.indexOf(element) !== index
    });
    if (dup) {
      this.warningMsg = 'ERROR: Duplicate numbers';
      this.dup = true;
    } else {
      this.warningMsg = '';
      this.dup = false;
    }
  }

}