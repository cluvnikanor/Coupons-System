import { Coupon } from './coupon';

export class UserMessageAndCoupon {
    public constructor(
        public message: string = "",
        public coupon?: Coupon
    ){}
}
