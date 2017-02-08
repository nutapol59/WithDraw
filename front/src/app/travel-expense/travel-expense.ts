import { DocumentMaster } from '../document-master/document-master';
import { AppUser } from '../app-user/app-user';
import { Company } from '../company/company';
import { Department } from '../department/department';
import { Bank } from '../bank/bank';
import { TravelExpenseDetail } from '../travel-expense-detail/travel-expense-detail';

export class TravelExpense extends DocumentMaster{
    expenseDate = new Date();
    employee:AppUser;
    company:Company;
    department:Department;
    comment:string;
    approvelDate = new Date();
    payDate = new Date();
    cash:number;
    chequeNumber:string;
    chequeBank:Bank;
    expenseSummary:number;
    travelExpenseDetails:Set<TravelExpenseDetail>;


}