import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { Customer } from './customer'
import { CustomerService } from '../customer/customer.service'

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer = new Customer();
  customerUpdate = new Customer();
  customers : Customer[];
  
  constructor(private customerService : CustomerService,private location:Location) {

   }

  ngOnInit() {
        this.getCustomers();
    }

    goBack(): void {
    this.location.back();
  }

    submitted = false;
    onSubmit() { this.submitted = true; }

    setIntitialOfActive(){
        this.customer.active = 1;
    }
   

     onClear(){
        this.customer.code="";
        this.customer.name="";
        this.customer.active=0;
        this.customer.address="";
    }

    onCheckBox(event){
        event.target.checked? (this.customer.active = 1) : (this.customer.active = 0)
        console.log(this.customer.active)
    }
    onCheckBoxUpdate(event){
        event.target.checked? (this.customerUpdate.active = 1) : (this.customerUpdate.active = 0)
        console.log(this.customerUpdate.active)
    }

    onClearUpdate(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement, address: HTMLInputElement){
        code.value = this.customerUpdate.code;
        name.value = this.customerUpdate.name;
        active.value = this.customerUpdate.active.toString();
        address.value = this.customerUpdate.address;
        if(this.customerUpdate.active == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
        }else{
            document.getElementById("activeinput").removeAttribute("checked");
        }

        console.log(code.value);
        console.log(name.value);
        console.log(active.value);
        console.log(address.value);
    }

   
    detailModalUpdate(customer : Customer){
        this.customerUpdate = customer;
        if(this.customerUpdate.active == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
        }else{
            document.getElementById("activeinput").removeAttribute("checked");
        }
        console.log(this.customerUpdate);
    }

    getCustomers() {
        this.customerService.getCustomers()
            .subscribe(
                (data) => this.customers = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.customers))
            )
    }

   
    addCustomer(){
        console.log(this.customer.code);
        console.log(this.customer.name);
        console.log(this.customer.active);
        console.log(this.customer.address);
        this.customerService.addCustomer(this.customer.code, this.customer.name
                                        , this.customer.active, this.customer.address)
                            .subscribe(
                                data => console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getCustomers()
                                    this.onClear()

                                }
                            )
    }

    deleteCustomer(customer:Customer){
        console.log(customer.id);
        this.customerService.deleteCustomer(customer.id)
                            .subscribe(
                                data => alert(data),
                                error => alert(error),
                                () => {
                                    this.getCustomers();
                                }
                            )
    }

    updateCustomer(code: HTMLInputElement,name: HTMLInputElement,
                   active: HTMLInputElement, address: HTMLInputElement){
        console.log(active.value)
        this.customerUpdate.code = code.value;
        this.customerUpdate.name = name.value;
        this.customerUpdate.active = parseInt(active.value);
        this.customerUpdate.address = address.value;
        console.log(this.customerUpdate);

        this.customerService.updateCustomer(this.customerUpdate)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getCustomers();
                                }
                            )
    }

}
