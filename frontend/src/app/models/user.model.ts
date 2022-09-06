import { Device } from "./device.model";
import { PhonePlan } from "./plan.model";

export class User {


    id!: number;
    userName: string;
    email: string;
    password: string;


    constructor(
        userName: string,
        email: string,
        password: string,

        ) {
            this.userName = userName;
            this.email = email;
            this.password = password;
        }
        
}