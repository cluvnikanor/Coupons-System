import { Customer } from './customer';

export class Coupon{

    public constructor(
        public id: number = 0,
        public companyId: number = 0,
        public categoryId: number = 0,
        public title: string = "",
        public description: string = "",
        public startDate = new Date,
        public endDate = new Date,
        public amount: number = 0,
        public price: number = 0,
        public image: string = "",
        public customers: Customer[] = [new Customer]
    ){}
 }