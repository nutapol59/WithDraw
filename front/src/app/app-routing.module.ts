import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HeaderComponent } from './header/header.component';
import { CompanyComponent } from './company/company.component';
import { DepartmentComponent } from './department/department.component';
import { AppUserComponent } from './app-user/app-user.component';
import { BankComponent } from './bank/bank.component';
import { CustomerComponent } from './customer/customer.component';
import { TravelExpenseComponent } from './travel-expense/travel-expense.component'
import { ListSentApproveComponent } from './list-sent-approve/list-sent-approve.component';
import { ApproveMapFlowComponent } from './approve-map-flow/approve-map-flow.component';

const routes: Routes = [
    // { path: '', redirectTo: '/', pathMatch: 'full' }, //remember / == /dashboard begin openWeb
  { path: '',  component: TravelExpenseComponent},
  { path: 'companies', component:CompanyComponent},
  { path: 'departments', component:DepartmentComponent},
  { path: 'appUsers' , component:AppUserComponent },
  { path: 'customers' , component:CustomerComponent },
  { path: 'banks' , component:BankComponent },
  { path: 'listSentApprove' , component:ListSentApproveComponent },
  { path: 'approveMapFlow' , component:ApproveMapFlowComponent }


//   { path: 'detail/:id', component: HeroDetailComponent },
//    //  :id is a placeholder to be filled with a specific hero id when navigating to the HeroDetailComponent.
//   { path: 'heroes',     component: HeroesComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}