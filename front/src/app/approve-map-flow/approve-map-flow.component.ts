import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';

import { ApproveMapFlow } from '../approve-map-flow/approve-map-flow';
import { AppUser } from '../app-user/app-user';

import { ApproveMapFlowService } from './approve-map-flow.service';
import { AppUserService } from '../app-user/app-user.service'
@Component({
  selector: 'app-approve-map-flow',
  templateUrl: './approve-map-flow.component.html',
  styleUrls: ['./approve-map-flow.component.css']
})
export class ApproveMapFlowComponent implements OnInit {
  apvmf = new ApproveMapFlow();
  apvmfs:ApproveMapFlow[];
  apvmfUpdate = new ApproveMapFlow();

  employee = new AppUser();
  employeeUpdate = new AppUser();
  employees: AppUser[];
  employeesUpdate:AppUser[];
  employeeId : number;
  employeeIdUpdate : number;

  apv1 = new AppUser();
  apv1Id:number;
  apv1IdUpdate:number;

  apv2 = new AppUser();
  apv2Id:number;
  apv2IdUpdate:number;

  account = new AppUser();
  accountId:number;
  accountIdUpdate:number;
  

  
  constructor(private approveMapFlowService:ApproveMapFlowService,private appUserService : AppUserService,private location:Location) {
                        
   }

  ngOnInit() {
    this.getApproveMapFlows();    
    }

    goBack(): void {
    this.location.back();
  }

    submitted = false;
    onSubmit() { this.submitted = true; }

    onSelectboxChange(event){
        // console.log("old Id  :"+this.departmentUpdate.company.id);
        
        // console.log("new Id Company : "+event); //id company update in selectBox
        // this.companyIdUpdate = event;
        // console.log(this.companyIdUpdate);

        //console.log(this.departmentUpdate.company); 
    }


     onClear(){
         this.employeeId=null;
         this.apv1Id=null;
         this.apv2Id=null;
         this.accountId=null;
    }


    onClearUpdate(employee: HTMLInputElement,apv1: HTMLInputElement,apv2: HTMLInputElement,account:HTMLInputElement){
        // employee.value = this.employeeUpdate.;
        // name.value = this.bankUpdate.name;
        // active.value = this.bankUpdate.active.toString();
        // if(this.bankUpdate.active == 1){
        //     document.getElementById("activeinput").setAttribute("checked","true");
        // }else{
        //     document.getElementById("activeinput").removeAttribute("checked");
        // }

        // console.log(code.value);
        // console.log(name.value);
        // console.log(active.value);
    }

   
    detailModalUpdate(apvmf : ApproveMapFlow){
        this.apvmfUpdate = apvmf;
        this.employeeUpdate = this.apvmfUpdate.employee;
        this.getAppUsers();
        console.log(this.apvmfUpdate);
    }

    getApproveMapFlows() {
        this.approveMapFlowService.getApproveMapFlows()
            .subscribe(
                (data) => this.apvmfs = data,
                error => alert(error),
                () =>{ console.log(JSON.stringify(this.apvmfs))
                // this.employee = this.apvmf.employee
        // this.apv1 = this.apvmf.apv1Emp
        // console.log(this.apv2.empName = this.apvmfs[0].apv2Emp.empName) 
        // this.account = this.apvmf.accountEmp     }
                    }
            )
    }

    getAppUsers() {
        this.appUserService.getAppUsers()
            .subscribe(
                data => {this.employees = data,
                         this.employeesUpdate = data },
                error => alert(error),
                () => console.log(this.employees)
            )
    }

   
    addApproveMapFlow(){
        // console.log(this.bank.code);
        // console.log(this.bank.name);
        // console.log(this.bank.active);
        this.approveMapFlowService.addApproveMapFlow(this.employeeId,this.apv1Id,
                                 this.apv2Id,this.accountId)
                            .subscribe(
                                data => console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    this.getApproveMapFlows()
                                    this.onClear()
                                }
                            )
    }

    deleteApproveMapFlow(apvmf:ApproveMapFlow){
        console.log(apvmf.id);
        this.approveMapFlowService.deleteApproveMapFlow(apvmf.id)
                            .subscribe(
                                data => alert(data),
                                error => alert(error),
                                () => {
                                    this.getApproveMapFlows();
                                }
                            )
    }

    updateApproveMapFlow(apvmf:ApproveMapFlow){
        console.log("======UPDATE=======")
        console.log("======OLD========")
        console.log(this.apvmfUpdate.apv1Emp.id);
        // console.log(apvmf.apv1Emp.id);
        // console.log(apvmf.apv2Emp.id);
        // console.log(apvmf.accountEmp.id);
        console.log("======NEW========")
        console.log(this.apvmfUpdate.employee.id);
        console.log(this.apv1IdUpdate);
        console.log(this.apv2IdUpdate);
        console.log(this.accountIdUpdate);

        this.approveMapFlowService.updateApproveMapFlow(this.apvmfUpdate.id,this.apvmfUpdate.employee.id,this.apv1IdUpdate,
                                                        this.apv2IdUpdate,this.accountIdUpdate)
                            .subscribe(
                                data=> console.log(JSON.stringify(data)),
                                error => alert(error),
                                () => {
                                    alert("UPDATE SUCCESS");
                                    this.getApproveMapFlows();
                                }
                            )
    }
}