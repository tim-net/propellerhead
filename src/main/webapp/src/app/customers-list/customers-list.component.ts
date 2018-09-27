import {Component, OnInit} from '@angular/core';
import {GridOptions} from 'ag-grid';
import {CustomersListFilter} from "./customers-list-filter";
import {CustomersListService} from "./customers-list.service";
import {Subscription} from "rxjs";
import {CustomerNameCell} from "./customer-name-cell";
import {DateComponent} from "../shared/date.component";

@Component({
  selector: 'customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {
  private static defaultListSize: number = 5;
  filter = new CustomersListFilter(CustomersListComponent.defaultListSize);
  currentPage = 1;
  records;
  countAllData;
  loadPending = false;
  private subscription: Subscription;
  gridOptions: GridOptions = <GridOptions>{
    sortingOrder: ["asc","desc"],
    onModelUpdated: () => {
      this.gridOptions.api.sizeColumnsToFit();
    },
    onGridSizeChanged: () => {
      this.gridOptions.api.sizeColumnsToFit();
    },
    onSortChanged: (params) => {
      let sortModel = this.gridOptions.api.getSortModel();
      this.filter.sort = sortModel[0].colId;
      if (sortModel[0].sort == 'desc') this.filter.sort = "-" + this.filter.sort;
      this.updateLayoutAndLoadData();
    }
  };
  columnDefs: any[];

  constructor(private service: CustomersListService) {
    this.gridOptions.columnDefs = this.createColumnDefs();
    this.gridOptions.enableSorting = true;
    this.gridOptions.pagination = false;
    this.gridOptions.paginationPageSize = this.filter.size;
  }

  private createColumnDefs() {
    return [
      {headerName: "Id", field: "id", width: 500},
      {headerName: "Name", field: "name", sort: 'asc', cellRendererFramework: CustomerNameCell, width: 500},
      {headerName: "Status", field: "status", width: 200},
      {headerName: "Created", field: "created", cellRendererFramework: DateComponent, width: 170}
    ];
  }

  private updateLayoutAndLoadData() {
    if (!!this.gridOptions.api) this.gridOptions.api.showLoadingOverlay();
    this.loadAll();
  }

  onGridReady(params) {
    this.updateLayoutAndLoadData();
    this.gridOptions.api.sizeColumnsToFit();
  }

  ngOnInit() {
  }

  private loadAll() {
    if (!!this.subscription) {
      this.subscription.unsubscribe();
    }
    this.loadPending = true;
    this.subscription = this.service.query(this.filter).subscribe(
      (data: any) => this.onSuccess(data),
      (data: any) => this.onError(data)
    );
  }

  private onSuccess(data) {
    this.countAllData = data["count"];
    this.records = data["customers"];
    this.loadPending = false;
  }

  pageChanged(event:any) {
    this.filter.page = event.page - 1;
    this.updateLayoutAndLoadData();
  }

  // noinspection JSMethodCanBeStatic
  private onError(error) {
    console.log(error);
  }
}
