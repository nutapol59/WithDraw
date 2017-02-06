import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { Company } from './company'
import { CompanyService } from '../company/company.service'



@Component({
  selector: 'company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css'],
  
})
export class CompanyComponent implements OnInit {
  company = new Company();
  companyUpdate = new Company();
  companies : Company[];
  
  constructor(private companyService : CompanyService,private location:Location) {

   }

  ngOnInit() {
        this.getCompanies();
    }

    goBack(): void {
    this.location.back();
  }

    submitted = false;
    onSubmit() { this.submitted = true; }

    setIntitialOfActive(){
        this.company.active = 1;
    }
   

     onClear(){
        this.company.code="";
        this.company.name="";
        this.company.active=0;
    }

    onCheckBox(event){
        event.target.checked? (this.company.active = 1) : (this.company.active = 0)
        console.log(this.company.active)
    }
    onCheckBoxUpdate(event){
        event.target.checked? (this.companyUpdate.active = 1) : (this.companyUpdate.active = 0)
        console.log(this.companyUpdate.active)
    }

    onClearUpdate(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement){
        code.value = this.companyUpdate.code;
        name.value = this.companyUpdate.name;
        active.value = this.companyUpdate.active.toString();
        if(this.companyUpdate.active == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
        }else{
            document.getElementById("activeinput").removeAttribute("checked");
        }

        console.log(code.value);
        console.log(name.value);
        console.log(active.value);
    }

   
    detailModalUpdate(company : Company){
        this.companyUpdate = company;
        if(this.companyUpdate.active == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
        }else{
            document.getElementById("activeinput").removeAttribute("checked");
        }
        console.log(this.companyUpdate);
    }

    getCompanies() {
        this.companyService.getCompanies()
            .subscribe(
                (data) => this.companies = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.companies))
            )
    }

   
    addCompany(){
        console.log(this.company.code);
        console.log(this.company.name);
        console.log(this.company.active);
        this.companyService.addCompany(this.company.code, this.company.name, this.company.active)
                            .subscribe(
                                data => console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getCompanies()
                                    this.onClear()

                                }
                            )
    }

    deleteCompany(company:Company){
        console.log(company.id);
        this.companyService.deleteCompany(company.id)
                            .subscribe(
                                data => alert(data),
                                error => alert(error),
                                () => {
                                    this.getCompanies();
                                }
                            )
    }

    updateCompany(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement){
        console.log(active.value)
        this.companyUpdate.code = code.value;
        this.companyUpdate.name = name.value;
        this.companyUpdate.active = parseInt(active.value);
        console.log(this.companyUpdate);

        this.companyService.updateCompany(this.companyUpdate)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getCompanies();
                                }
                            )
    }


    // updateCompany(companyUpdate:Company){
    //     this.companyService.updateCompany(this.companyUpdate)
    //                         .subscribe(
    //                             data=> console.log(JSON.stringify(data)),
    //                             error => alert(error),
    //                             () => {
    //                                 alert("UPDATE SUCCESS");
    //                                 this.getCompanies();
    //                             }
    //                         )
    // }



}
