import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Domain } from '../common/domain';


@Injectable({
  providedIn: 'root'
})
export class DomainService {
 

  private baseUrl= 'http://localhost:8080/domains';

  constructor(private httpClient: HttpClient) { }

  getDomain(id:number):Observable<Domain>{
    return this.httpClient.get<Domain>(`${this.baseUrl}/id/${id}`);

  }

  getDomainList():Observable<Domain[]>{
    return this.httpClient.get<Domain[]>(this.baseUrl);
  

  }

  deleteDomain(id:number):Observable<any>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`, {responseType : 'text'});

  }

  updateDomain(id:number, domain:Domain): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`, domain);
  }

  addDomain(domain:Domain): Observable<Object> {
    return this.httpClient.post(this.baseUrl, domain);
  }

  
}
