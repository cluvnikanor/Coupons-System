import { Company } from './company';

export class UserMessageAndCompanies {
    public constructor(
        public message: string = "",
        public companies?: Company[]
    ){}
}
