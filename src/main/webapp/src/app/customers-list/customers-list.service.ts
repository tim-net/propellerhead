import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {CustomersListFilter} from "./customers-list-filter";

@Injectable({
  providedIn: 'root'
})
export class CustomersListService {

  private resourceUrl = 'api/customer';

  constructor(private http: HttpClient) {
  }

  query(filter: CustomersListFilter): Observable<any> {
    return this.http.get(this.resourceUrl + "/find-all", {params: filter.params});
  }
}
