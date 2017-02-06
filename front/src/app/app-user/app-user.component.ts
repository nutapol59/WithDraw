import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';

import { Department } from '../department/department';
import { Company } from '../company/company';
import { AppUser } from './app-user';

import { DepartmentService } from '../department/department.service';
import { CompanyService } from '../company/company.service';
import { AppUserService } from './app-user.service';

@Component({
  selector: 'app-app-user',
  templateUrl: './app-user.component.html',
  styleUrls: ['./app-user.component.css']
})
export class AppUserComponent implements OnInit {
  company = new Company();
  companyUpdate = new Company();
  companies : Company[];
  companyId : number;
  companyIdUpdate : number;

  department = new Department();
  departmentUpdate = new Department();
  departments : Department[];
  departmentId : number;
  departmentIdUpdate : number;


  appUser = new AppUser();
  appUserUpdate = new AppUser();
  appUsers : AppUser[];



  
  
  constructor(private companyService : CompanyService,private departmentService:DepartmentService,
              private appUserService : AppUserService, private location:Location) {

   }

  ngOnInit() {
        this.getAppUsers();
    }

    goBack(): void {
    this.location.back();
  }

    submitted = false;
    onSubmit() { this.submitted = true; }

     onClear(){
      //  this.appUser = null;
        this.appUser.empCode="";
        this.appUser.empName="";
        this.appUser.empLastName="";
        this.appUser.empAddress="";
        this.appUser.personalId="";
        this.appUser.tel="";
        this.appUser.email="";
        this.appUser.ldapUserName="";
        this.appUser.password="";
        this.appUser.department=null;
        this.appUser.company=null;
        
    }

     onSelectboxDepChange(event){
        console.log("old Id Department :"+this.appUserUpdate.department.id);
        
        console.log("new Id Department : "+event); //id company update in selectBox
        this.departmentIdUpdate = event;
        console.log(this.departmentIdUpdate);

        //console.log(this.departmentUpdate.company); 
    }

     onSelectboxCompanyChange(event){
        console.log("old Id Company :"+this.appUserUpdate.company.id);
        
        console.log("new Id Company : "+event); //id company update in selectBox
        this.companyIdUpdate = event;
        console.log(this.companyIdUpdate);

        //console.log(this.departmentUpdate.company); 
    }

    onClearUpdate(empCode: HTMLInputElement,empName: HTMLInputElement,empLastName: HTMLInputElement,
                  empAddress: HTMLInputElement,personalId: HTMLInputElement,tel: HTMLInputElement,
                  email: HTMLInputElement,ldapUserName: HTMLInputElement,password: HTMLInputElement,
                  department: HTMLInputElement,company: HTMLInputElement){
        empCode.value = this.appUserUpdate.empCode;
        empName.value = this.appUserUpdate.empName;
        empLastName.value = this.appUserUpdate.empLastName;
        empAddress.value = this.appUserUpdate.empAddress;
        personalId.value = this.appUserUpdate.personalId;
        tel.value = this.appUserUpdate.tel;
        email.value = this.appUserUpdate.email;
        ldapUserName.value = this.appUserUpdate.ldapUserName;
        password.value = this.appUserUpdate.password;
        department.value = this.appUserUpdate.department.name;
        company.value = this.appUserUpdate.company.name;
    }

   
    detailModalUpdate(appUser : AppUser){
        this.appUserUpdate = appUser;
        console.log(this.appUserUpdate);
    }

    getAppUsers() {
        this.appUserService.getAppUsers()
            .subscribe(
                (data) => this.appUsers = data,
                error => alert(error),
                () => console.log("getAppUserComplete")
            )
    }

    getCompanies() {
        this.companyService.getCompanies()
            .subscribe(
                (data) => this.companies = data,
                error => alert(error),
                () => console.log("getCompaniesComplete")
            )
    }

    getDepartments() {
        this.departmentService.getDepartments()
            .subscribe(
                (data) => this.departments = data,
                error => alert(error),
                () => console.log("getDepartmentsComplete")
            )
    }

   
    addAppUser(){
       console.log(this.appUser.empCode);
       console.log(this.appUser.empName);
       console.log(this.appUser.empLastName);
       console.log(this.appUser.empAddress);
       console.log(this.appUser.personalId);
       console.log(this.appUser.tel);
       console.log(this.appUser.email);
       console.log(this.appUser.ldapUserName);
       console.log(this.appUser.password);
       console.log(this.departmentId);
       console.log(this.companyId);
       
        this.appUserService.addAppUser(this.appUser.empCode, this.appUser.empName, this.appUser.empLastName,
                                      this.appUser.empAddress, this.appUser.personalId, this.appUser.tel,
                                      this.appUser.email, this.appUser.ldapUserName, this.appUser.password,
                                      this.departmentId,this.companyId)
                            .subscribe(
                                data => console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getAppUsers()
                                    this.onClear()

                                }
                            )
    }

    deleteAppUser(appUser:AppUser){
        console.log(appUser.id);
        this.appUserService.deleteAppUser(appUser.id)
                            .subscribe(
                                data => alert(data),
                                error => alert(error),
                                () => {
                                    this.getAppUsers();
                                }
                            )
    }

    updateAppUser(empCode: HTMLInputElement,empName: HTMLInputElement,empLastName: HTMLInputElement,
                  empAddress: HTMLInputElement,personalId: HTMLInputElement,tel: HTMLInputElement,
                  email: HTMLInputElement,ldapUserName: HTMLInputElement,password: HTMLInputElement,
                  companyIdUpdate:number,departmentIdUpdate:number){
        
        console.log("companyIdUpdate = "+companyIdUpdate);
        console.log("departmentIdUpdate = "+departmentIdUpdate);
        this.appUserUpdate.empCode = empCode.value;
        this.appUserUpdate.empName = empName.value;
        this.appUserUpdate.empLastName = empLastName.value;
        this.appUserUpdate.empAddress = empAddress.value;
        this.appUserUpdate.personalId = personalId.value;
        this.appUserUpdate.tel = tel.value;
        this.appUserUpdate.email = email.value;
        this.appUserUpdate.ldapUserName = ldapUserName.value;
        this.appUserUpdate.password = password.value;
    
        
        this.appUserUpdate.company.id = companyIdUpdate == null ? this.appUserUpdate.company.id : companyIdUpdate;
        this.appUserUpdate.department.id = departmentIdUpdate == null ? this.appUserUpdate.department.id : departmentIdUpdate;
        
       

        this.appUserService.updateAppUser(this.appUserUpdate.id, this.appUserUpdate.empCode, this.appUserUpdate.empName,
                                                this.appUserUpdate.empLastName, this.appUserUpdate.empAddress,
                                                this.appUserUpdate.personalId, this.appUserUpdate.tel,
                                                this.appUserUpdate.email, this.appUserUpdate.ldapUserName,
                                                this.appUserUpdate.password, this.appUserUpdate.department.id, this.appUserUpdate.company.id)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getAppUsers();
                                }
                            )
    }

}
