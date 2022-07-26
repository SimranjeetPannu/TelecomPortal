import { Device } from "./device.model";
import { PhonePlan } from "./plan.model";

export class LoggedUser {

    id!: number;
    userName: string;
    email: string;
    password: string;
    plans: Array<PhonePlan>;
    devices: Array<Device>;

    constructor(
        userName: string,
        email: string,
        password: string,
        plans: Array<PhonePlan>,
        devices: Array<Device>
        ) {
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.plans = plans;
            this.devices = devices
        }
        
}