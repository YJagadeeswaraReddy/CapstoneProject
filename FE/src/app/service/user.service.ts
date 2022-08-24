import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }



  registerUser(user: any) {
    return this.http.post<any>("http://localhost:8181/register", user);
  }



  getAllUser() {
    return this.http.get<any>("http://localhost:8181/user/getall");
  }

  getUserByUsername(username:any){
    return this.http.get<any>("http://localhost:8181/user/get/"+username);
  }



  updateUser(user:any,username:string){
    return this.http.put<any>("http://localhost:8181/user/update/"+username, user);
  }

  deleteUser(username:string){
    return this.http.delete<any>("http://localhost:8181/user/delete/"+username);
  }



}
