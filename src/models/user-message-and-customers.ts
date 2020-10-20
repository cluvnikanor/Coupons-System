import { Customer } from './customer';

export class UserMessageAndCustomers {
    public constructor(
        public message: string = "",
        public customers?: Customer[]
    ){}
}
