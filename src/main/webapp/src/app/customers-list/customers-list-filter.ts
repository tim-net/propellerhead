import {HttpParams} from '@angular/common/http';
import {isNullOrUndefined} from "util";

export class CustomersListFilter {
  params: HttpParams = new HttpParams();

  constructor(size: number, name: string = undefined, page: number = undefined, sort: string = 'name') {
    this.size = size;
    this.page = 0;
    this.name = name;
    this.sort = sort;
  }

  set size(value: number) {
    this.params = this.params.set('size', value.toString());
  }

  set name(value: string) {
    if(value) {
      this.params = this.params.set('name', value.toString());
    }
  }

  get name(): string {
    return this.params.get('name');
  }

  get size(): number {
    return Number.parseInt(this.params.get('size'));
  }

  get page(): number {
    let raw = this.params.get('size');
    if (isNullOrUndefined(raw)) return undefined;
    return Number.parseInt(this.params.get('size'));
  }

  set page(value: number) {
    this.params = this.params.set('page', value.toString());
  }

  get sort(): string {
    return this.params.get('sort');
  }

  set sort(value: string) {
    this.params = this.params.set('sort', value);
  }
}
