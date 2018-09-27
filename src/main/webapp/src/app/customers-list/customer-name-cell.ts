import {Component} from "@angular/core";
import {ICellRendererAngularComp} from "ag-grid-angular/src/interfaces";

@Component({
  template: `<a [routerLink]="['/customer-details', id]">{{name}}</a>
    `
})
export class CustomerNameCell  implements ICellRendererAngularComp {
  public name:string;
  public id:number;

  agInit(params: any): void {
    this.name = params.value;
    this.id = params.data['id'];
  }

  refresh(params: any): boolean {
    return false;
  }

}
