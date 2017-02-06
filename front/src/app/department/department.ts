import { baseEntity } from "../baseEntity/baseEntity"
import { Company } from "../company/company"
export class Department extends baseEntity{
    company : Company;
}