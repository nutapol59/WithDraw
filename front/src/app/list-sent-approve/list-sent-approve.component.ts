import { Component, OnInit,Input } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';

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
  appUserId:number;


  constructor(private travelExpenseService:TravelExpenseService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    // this.route.params.switchMap((params: Params) => this.appUserId = params['id'])
    // .subscribe(data => this.appUserId = data)
    this.appUserId = this.route.snapshot.params['id'];
    console.log(this.appUserId);
    this.getTravelExpensesByAppUserId();
  }

  getTravelExpenses(){
    this.travelExpenseService.getTravelExpenses()
            .subscribe(
                (data) => this.travelExpenses = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.travelExpenses))
            )
  }

  getTravelExpensesByAppUserId(){
    this.travelExpenseService.getTravelExpensesByAppUserId(this.appUserId)
            .subscribe(
                (data) => this.travelExpenses = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.travelExpenses))
            )
  }

}
