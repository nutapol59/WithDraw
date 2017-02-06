import { Company } from '../company/company';
import { Department } from '../department/department';
export class AppUser{
    id : number;
    version : number;
    empCode : string;
    empName : string;
    empLastName : string;
    empAddress : string;
    personalId : string;
    tel : string;
    email : string;
    ldapUserName : string;
    password : string;
    department : Department;
    company : Company;
    // appUserRole : Set<AppUserRole>


}