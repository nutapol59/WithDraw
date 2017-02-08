import { Component, OnInit } from '@angular/core';

 import { TravelExpense } from '../travel-expense/travel-expense'
 import { TravelExpenseService } from '../travel-expense/travel-expense.service'

@Component({
  selector: 'app-list-sent-approve',
  templateUrl: './list-sent-approve.component.html',
  styleUrls: ['./list-sent-approve.component.css']
})
export class ListSentApproveComponent implements OnInit {
  travelExpenses:TravelExpense[];
  travelExpense:TravelExpense;

  constructor(private travelExpenseService:TravelExpenseService) { }

  ngOnInit() {
    this.getTravelExpenses();
  }

  getTravelExpenses(){
    this.travelExpenseService.getTravelExpenses()
            .subscribe(
                (data) => this.travelExpenses = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.travelExpenses))
            )
  }

}
