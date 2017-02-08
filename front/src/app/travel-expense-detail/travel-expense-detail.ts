import { Customer } from '../customer/customer';
import { TravelExpense } from '../travel-expense/travel-expense';
export class TravelExpenseDetail{
    id:number;
    version:number;
    travelDate = new Date();
    customer:Customer;
    travelFrom:string;
    travelTo:string;
    expense:number;
    expWayExpense:number;
    expenseSubSummary:number;
    comment:string;
    attachFile1:string;
    attachFile2:string;
    attachFile3:string;
    travelExpense:TravelExpense;
}