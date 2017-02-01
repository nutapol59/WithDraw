import { Component, OnInit } from '@angular/core';
import { Company } from './company'
import { CompanyService } from '../company/company.service'

@Component({
  selector: 'company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css'],
  
})
export class CompanyComponent implements OnInit {
  company = new Company();
  companies : Company[];
  constructor(private companyService : CompanyService) {

   }

  ngOnInit() {
        this.getCompanies();
    }

    detailModalUpdate(company : Company){
        this.company = company;
        console.log(this.company.name)
    }

    getCompanies() {
        this.companyService.getCompanies()
            .subscribe(
                (data) => this.companies = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.companies))
            )
    }

     submitted = false;
    onSubmit() { this.submitted = true; }
    onClear(){
        this.company.code="";
        this.company.name="";
        this.company.active=null;
    }


    addCompany(){
        this.companyService.addCompany(this.company.code, this.company.name, this.company.active)
                            .subscribe(
                                data => console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getCompanies()
                                    this.company.code=""
                                    this.company.name=""
                                    this.company.code=null

                                }
                            )
       
    }

    deleteCompany(company:Company){
        console.log(company.id);
        this.companyService.deleteCompany(company.id)
                            .subscribe(
                                data => console.log(data),
                                error => alert(error),
                                () => {
                                    this.getCompanies();
                                }
                            )
    }

    updateCompany(company:Company){
        this.companyService.updateCompany(company)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getCompanies();
                                }
                            )
    }



}
