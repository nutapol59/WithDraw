import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HeaderComponent } from './header/header.component'
import { CompanyComponent } from './company/company.component'
import { FormWithDrawComponent } from './form-with-draw/form-with-draw.component';
// import { BankComponent } from './customers/customers.component'

const routes: Routes = [
    // { path: '', redirectTo: '/', pathMatch: 'full' }, //remember / == /dashboard begin openWeb
  { path: '',  component: FormWithDrawComponent},
  { path: 'companies', component:CompanyComponent}

//   { path: 'detail/:id', component: HeroDetailComponent },
//    //  :id is a placeholder to be filled with a specific hero id when navigating to the HeroDetailComponent.
//   { path: 'heroes',     component: HeroesComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}