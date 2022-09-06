export class Device {

    id!: number;
    deviceName: string;
    phoneNumber: string;
    planid: number;

    constructor(
        deviceName: string,
        phoneNumber: string,
        planid: number
        ) {
            this.deviceName = deviceName;
            this.phoneNumber = phoneNumber;
            this.planid = planid;
        }
}