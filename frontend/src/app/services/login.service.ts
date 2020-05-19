import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl= 'http://localhost:8080/login';

  constructor(private httpClient: HttpClient) { }

  authenticate(username:string, password:string){
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ":" + password)});
    return this.httpClient.get(this.baseUrl, { headers, responseType: 'text' as 'json'}).pipe(
      map(
        data => {
          sessionStorage.setItem('username', username);
          let authString = 'Basic ' + btoa(username + ":" + password);
          sessionStorage.setItem('basicauth', authString);
          return data;
        }
      )
    );
    
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);

  }

  logOut(){
    sessionStorage.removeItem('username');
  }


}
