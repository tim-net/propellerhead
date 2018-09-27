import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {CustomerDetailsModel} from "./customer-details-model";

@Injectable({
  providedIn: 'root'
})
export class CustomersDetailsService {

  private resourceUrl = 'api/customer';

  constructor(private http: HttpClient) {
  }

  find(id: number): Observable<any> {
    return this.http.get(this.resourceUrl + "/details/" + id, {});
  }

  save(customer:CustomerDetailsModel):Observable<CustomerDetailsModel> {
    return this.http.post<CustomerDetailsModel>(this.resourceUrl + "/save", customer);
  }

}
