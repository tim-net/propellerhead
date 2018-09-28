import {CommonModule} from "@angular/common";
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {CustomerDetailsComponent} from "./customer-details.component";
import {FormsModule} from "@angular/forms";
import {NoteEditComponent} from "./note-edit.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [
    CustomerDetailsComponent,
    NoteEditComponent
  ],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CustomersDetailsModule {

}
