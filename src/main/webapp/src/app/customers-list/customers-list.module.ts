import {CommonModule} from "@angular/common";
import {AgGridModule} from "ag-grid-angular";
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {CustomersListComponent} from "./customers-list.component";
import {CustomersListService} from "./customers-list.service";
import {CustomerNameCell} from "./customer-name-cell";
import {RouterModule} from "@angular/router";
import {DateComponent} from "../shared/date.component";
import {PaginationModule} from "ngx-bootstrap";
import {FormsModule} from "@angular/forms";
import {CustomerStatusCell} from "./customer-status-cell";

@NgModule({
  imports: [
    AgGridModule.withComponents([CustomerNameCell, DateComponent, CustomerStatusCell]),
    CommonModule,
    RouterModule,
    FormsModule,
    PaginationModule.forRoot()
  ],
  declarations: [
    CustomerNameCell,
    DateComponent,
    CustomersListComponent,
    CustomerStatusCell
  ],
  entryComponents: [
    CustomerNameCell,
    DateComponent
  ],
  providers: [
    CustomersListService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CustomersListModule {

}
