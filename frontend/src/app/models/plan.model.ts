export class PhonePlan {

    id!: number;
    planName: string;
    deviceLimit: number;
    price: number;
    customerid: number;
    
    constructor(
        planName: string,
        deviceLimit: number,
        price: number,
        customerid: number
        ) {
            this.planName = planName;
            this.deviceLimit = deviceLimit;
            this.price = price;
            this.customerid = customerid;
        }
}