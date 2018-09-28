import {Component, OnInit} from '@angular/core';
import {CustomerDetailsModel, CustomerNote} from "./customer-details-model";
import {CustomersDetailsService} from "./customers-details.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from '@angular/common';
import {CustomerStatus} from "../shared/models";

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  public customer: CustomerDetailsModel;
  private _saveCustomerStatus: SaveStatus;

  constructor(private service: CustomersDetailsService, private route: ActivatedRoute, private location: Location) {
  }

  ngOnInit() {
    this.getCustomer();
  }

  goBack(): void {
    this.location.back();
  }

  saveCustomer(): void {
    this.service.save(this.customer).subscribe(r => this.onSaveCustomer(r));
  }

  onSaveCustomer(result: boolean) {
    if (result) {
      this._saveCustomerStatus = SaveStatus.SUCCESS;
    } else {
      this._saveCustomerStatus = SaveStatus.ERROR;
    }
  }

  private getCustomer(): void {
    const id: number = Number.parseInt(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.service.find(id).subscribe(c => {
        this.customer = c;
        this.customer.notes = c.notes.map(n => new CustomerNote(n.id, n.content));
      })
    }
  }

  addNote(): void {
    let customerNote = new CustomerNote();
    customerNote.isNew = true;
    customerNote.editing = true;
    this.customer.notes.push(customerNote);
  }

  editNote(note: CustomerNote): void {
    note.editing = true
    note.isNew = false;
  }


  get saveCustomerStatus(): SaveStatus {
    return this._saveCustomerStatus;
  }

  customerStatusKeys(): string[] {
    return Object.keys(CustomerStatus);
  }

  customerStatusValue(key: string) {
    return CustomerStatus[key];
  }
}

export enum SaveStatus {
  SUCCESS = "SUCCESS", ERROR = "ERROR"
}
