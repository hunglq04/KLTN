import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const baseUrl = 'http://localhost:8888/api';

export class User {
    constructor (
        public status: string,
    ) {}
}

export class LoginResponse {
    constructor(
        public token: string,
    ) {}
}

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {

    constructor(
        private httpClient: HttpClient
    ) {}

    authenticate(idCard, password) {
        return this.httpClient.post<LoginResponse>(`${baseUrl}/login`,{idCard,password})
            .toPromise()
            .then( res => {
                 sessionStorage.setItem('idCard',idCard);
                 sessionStorage.setItem('token', 'Bearer ' + res.token);
                 return res;
            })
            .catch(err => {
                console.error(err)
            })
      }
  

    isUserLoggedIn() {
        return sessionStorage.getItem('idCard') != null;
    }

    logOut() {
        sessionStorage.removeItem('idCard');
    }

}