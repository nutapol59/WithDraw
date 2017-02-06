import { Component, OnInit,Input,ElementRef,ViewChild } from '@angular/core';
import { Location } from '@angular/common';

import { Department } from './department';
import { Company } from '../company/company';
import { DepartmentService } from '../department/department.service';
import { CompanyService } from '../company/company.service';
@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})


export class DepartmentComponent implements OnInit {

  department = new Department();
  departmentUpdate = new Department();
  departmentUpdateFake = new Department();
  departments : Department[];
  companyId : number;
  companyIdUpdate : number;
  company = new Company();
  activeFake = 0;
  
  companies : Company[];

  constructor(private departmentService : DepartmentService,private companyService: CompanyService, private location:Location,private elementRef : ElementRef) {
       var el = elementRef.nativeElement;
       
   }

   
  ngOnInit() {
        this.getDepartments();
        
    }

    goBack(): void {
    this.location.back();
  }

    submitted = false;
    onSubmit() { this.submitted = true; }

    setIntitialOfActive(){
        this.department.active = 1;
    }
   

     onClear(){
        this.department.code="";
        this.department.name="";
        this.department.active=0;
        this.department.company=null;
    }

    onCheckBox(event){
        event.target.checked? (this.department.active = 1) : (this.department.active = 0)
        console.log(this.department.active)
    }



    onSelectBox(company){
        // event.target.values? (this.company = event.value): console.log("maimee");
        console.log(this.company.name)
    }

    onSelectboxChange(event){
        console.log("old Id Company :"+this.departmentUpdate.company.id);
        
        console.log("new Id Company : "+event); //id company update in selectBox
        this.companyIdUpdate = event;
        console.log(this.companyIdUpdate);

        //console.log(this.departmentUpdate.company); 
    }

    onCheckBoxUpdate(event){
       
        event.target.checked? (this.activeFake = 1) : (this.activeFake = 0);
       
        event.target.checked?document.getElementById("activeinput").setAttribute("checked","true"):document.getElementById("activeinput").removeAttribute("checked");
        console.log(this.activeFake);

    }

    onClearUpdate(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement,select : HTMLInputElement){
         this.activeFake = 0;
         console.log(this.activeFake);

         console.log(active.checked);
         console.log(active.value);

         code.value = this.departmentUpdate.code;
         name.value = this.departmentUpdate.name;
         active.value = this.departmentUpdate.active.toString();
         
    }

    detailModalUpdate(department : Department){
        //this.activeFake = 0;
        console.log(document.getElementById("activeinput").getAttribute("value"));       
        this.departmentUpdate = department;
        console.log("deUp Ac : "+ this.departmentUpdate.active);
        this.activeFake = this.departmentUpdate.active;
        console.log("Active Fake: "+this.activeFake)
        if(this.activeFake == 1){
            document.getElementById("activeinput").setAttribute("checked","true");
            document.getElementById("activeinput").setAttribute("value","1");
        }else if(this.activeFake == 0){
            document.getElementById("activeinput").removeAttribute("checked");  
        }
    }

    getDepartments() {
        this.departmentService.getDepartments()
            .subscribe(
                (data) => this.departments = data,
                error => alert(error),
                () => console.log(JSON.stringify(this.departments))
            )
    }

   
    addDepartment(){
        console.log(this.department.code);
        console.log(this.department.name);
        console.log(this.department.active);
        console.log(this.companyId);

        this.departmentService.addDepartment(this.department.code, this.department.name, this.department.active,this.companyId)
                            .subscribe(
                                data => alert(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getDepartments()
                                    this.onClear()

                                }
                            )
    }

    testLog(){
        //console.log(document.getElementById("selectCompany").getAttribute("value"));
      console.log(this.department.code);
      console.log(this.department.name);
      console.log(this.department.active);
      console.log(this.department.company = this.company);
      console.log(this.department.name)
      //console.log(this.company.id);
    }

    deleteDepartment(department:Department){
        console.log(department.id);
        this.departmentService.deleteDepartment(department.id)
                            .subscribe(
                                data => alert(data),
                                error => alert("fail"+error),
                                () => {
                                    this.getDepartments();
                                }
                            )
    }

    updateDepartment(code: HTMLInputElement,name: HTMLInputElement,active: HTMLInputElement,companyIdUpdate:number){
        console.log(active.value)
        console.log(companyIdUpdate);
        this.departmentUpdate.code = code.value;
        this.departmentUpdate.name = name.value;
        this.departmentUpdate.active = this.activeFake;
        
        this.departmentUpdate.company.id = companyIdUpdate == null ? this.departmentUpdate.company.id : companyIdUpdate;
        
       

        this.departmentService.updateDepartment(this.departmentUpdate.id,this.departmentUpdate.code,this.departmentUpdate.name,
                                                this.departmentUpdate.active,this.departmentUpdate.company.id)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getDepartments();
                                }
                            )
    }

    getCompanies() {
        this.companyService.getCompanies()
            .subscribe(
                (data) => this.companies = data,
                error => alert(error),
                () => console.log(JSON.stringify("Company List"+this.companies))
            )
    }


}
