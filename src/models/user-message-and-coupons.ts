import { Coupon } from './coupon';

export class UserMessageAndCoupons {
    public constructor(
        public message: string = "",
        public coupons?: Coupon[]
    ){}
}
