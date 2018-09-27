import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {CustomerDetailsComponent} from "./customer-details.component";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [
    CustomerDetailsComponent,
  ],
  entryComponents: [
  ],
  providers: []
})
export class CustomersDetailsModule {

}
