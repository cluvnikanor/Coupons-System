import { Company } from './company';

export class UserMessageAndCompany {
    public constructor(
        public message: string = "",
        public company?: Company
    ){}
}
