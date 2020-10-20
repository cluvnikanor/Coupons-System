import { Customer } from './customer';

export class UserMessageAndCustomer {
    public constructor(
        public message: string = "",
        public customer?: Customer
    ){}
}
