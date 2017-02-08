import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { TravelExpense } from './travel-expense'
import { TravelExpenseService } from '../travel-expense/travel-expense.service'



@Component({
  selector: 'app-travel-expense',
  templateUrl: './travel-expense.component.html',
  styleUrls: ['./travel-expense.component.css']
})
export class TravelExpenseComponent implements OnInit {
  
  travelExpenses:TravelExpense[];

  constructor(private travelExpenseService:TravelExpenseService) { }

  ngOnInit() {
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
