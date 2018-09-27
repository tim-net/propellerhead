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


  constructor(id: number = null, content: string = null, editing: boolean = false) {
    this.id = id;
    this.content = content;
    this.editing = editing;
  }
}


