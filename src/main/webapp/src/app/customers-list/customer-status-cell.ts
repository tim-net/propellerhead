import {Component} from "@angular/core";
import {ICellRendererAngularComp} from "ag-grid-angular/src/interfaces";
import {CustomerStatus} from "../shared/models";

@Component({
  template: `{{formattedValue}}`
})
export class CustomerStatusCell implements ICellRendererAngularComp {
  public formattedValue: string;

  agInit(params: any): void {
    this.formattedValue = CustomerStatus[params.value];
  }

  refresh(params: any): boolean {
    return false;
  }

}
