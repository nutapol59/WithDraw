import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { Bank } from './bank'
import { BankService } from '../bank/bank.service'

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit {
  
  bank = new Bank();
  bankUpdate = new Bank();
  banks : Bank[];
  
  constructor(private bankService : BankService,private location:Location) {

   }

  ngOnInit() {
        this.getBanks();
    }

    goBack(): void {
    this.location.back();
  }

    submitted = false;
    onSubmit() { this.submitted = true; }

    setIntitialOfActive(){
        this.bank.active = 1;
    }
   

     onClear(){
        this.bank.code="";
        this.bank.name="";
        this.bank.active=0;
    }

    onCheckBox(event){
        event.target.checked? (this.bank.active = 1) : (this.bank.active = 0)
        console.log(this.bank.active)
    }
    onCheckBoxUpdate(event){
        event.target.checked? (this.bankUpdate.active = 1) : (this.bankUpdate.active = 0)
        console.log(this.bankUpdate.active)
    }

    onClearUpdate(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement){
        code.value = this.bankUpdate.code;
        name.value = this.bankUpdate.name;
        active.value = this.bankUpdate.active.toString();
        if(this.bankUpdate.active == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
        }else{
            document.getElementById("activeinput").removeAttribute("checked");
        }

        console.log(code.value);
        console.log(name.value);
        console.log(active.value);
    }

   
    detailModalUpdate(bank : Bank){
        this.bankUpdate = bank;
        if(this.bankUpdate.active == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
        }else{
            document.getElementById("activeinput").removeAttribute("checked");
        }
        console.log(this.bankUpdate);
    }

    getBanks() {
        this.bankService.getBanks()
            .subscribe(
                (data) => this.banks = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.banks))
            )
    }

   
    addBank(){
        console.log(this.bank.code);
        console.log(this.bank.name);
        console.log(this.bank.active);
        this.bankService.addBank(this.bank.code, this.bank.name, this.bank.active)
                            .subscribe(
                                data => console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getBanks()
                                    this.onClear()

                                }
                            )
    }

    deleteBank(bank:Bank){
        console.log(bank.id);
        this.bankService.deleteBank(bank.id)
                            .subscribe(
                                data => alert(data),
                                error => alert(error),
                                () => {
                                    this.getBanks();
                                }
                            )
    }

    updateBank(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement){
        console.log(active.value)
        this.bankUpdate.code = code.value;
        this.bankUpdate.name = name.value;
        this.bankUpdate.active = parseInt(active.value);
        console.log(this.bankUpdate);

        this.bankService.updateBank(this.bankUpdate)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getBanks();
                                }
                            )
    }

}
