import {CustomerStatus} from "../shared/models";

export class CustomerDetailsModel {
  name: string;
  contact: string;
  status: CustomerStatus;
  notes: CustomerNote[];
}

export class CustomerNote {
  id: number;
  content: string;
  editing: boolean;
  private _isNew: boolean;


  constructor(id: number = null, content: string = null, editing: boolean = false, isNew: boolean = false) {
    this.id = id;
    this.content = content;
    this.editing = editing;
  }

  get isNew(): boolean {
    return this._isNew;
  }

  set isNew(value: boolean) {
    this._isNew = value;
  }
}


