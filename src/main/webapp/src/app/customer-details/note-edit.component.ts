import {Component, Input, OnInit} from "@angular/core";
import {CustomerNote} from "./customer-details-model";

@Component({
  selector: 'app-note-edit',
  templateUrl: './note-edit.component.html'
})
export class NoteEditComponent implements OnInit {
  @Input() note: CustomerNote;
  @Input() notes: CustomerNote[];
  private _noteContentEditing: string;

  get noteContentEditing(): string {
    return this._noteContentEditing;
  }

  set noteContentEditing(value: string) {
    this._noteContentEditing = value;
  }

  saveNote(note: CustomerNote): void {
    this.note.content = this.noteContentEditing;
    note.editing = false;
  }

  cancelForm(): void {
    this.note.editing = false;
    if (this.note.isNew) {
      const index = this.notes.indexOf(this.note, 0);
      if (index > -1) {
        this.notes.splice(index, 1);
      }
    }
  }

  ngOnInit(): void {
    this._noteContentEditing = this.note.content;
  }
}
