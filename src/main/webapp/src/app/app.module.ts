import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CustomersListComponent} from './customers-list/customers-list.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {CustomersListModule} from "./customers-list/customers-list.module";
import {CustomerDetailsComponent} from './customer-details/customer-details.component';
import {CustomersDetailsModule} from "./customer-details/customers-details.module";

const appRoutes: Routes = [
  {
    path: 'customers-list',
    component: CustomersListComponent,
    data: {
      pageTitle: 'Customers'
    }
  },{
    path: 'customer-details/:id',
    component: CustomerDetailsComponent,
    data: {
      pageTitle: 'Customer details'
    }
  },
  {
    path: '',
    redirectTo: 'customers-list',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full'
  }
];
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    CustomersListModule,
    CustomersDetailsModule
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
