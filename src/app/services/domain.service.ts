import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Domain } from '../common/domain';
import {tap} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class DomainService {
 

  private baseUrl= 'http://localhost:8080/domains';

  private _refreshNeeded$ = new Subject<void>();

  constructor(private httpClient: HttpClient) { }

  get refreshNeeded$(){
    return this._refreshNeeded$;
  }

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
    return this.httpClient.put(`${this.baseUrl}/${id}`, domain).pipe(
      tap(() => {
        this._refreshNeeded$.next();
      })
    );;
  }

  addDomain(domain:Domain): Observable<Domain>{
    return this.httpClient.post<Domain>(`${this.baseUrl}/add`, domain).pipe(
      tap(() => {
        this._refreshNeeded$.next();
      })
    );
  }

  
}
