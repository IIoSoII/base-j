import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EsbServiceService {
  private res: any;
  constructor(private http: HttpClient) {  }

  getResponse(){
    this.http.get('https://api.publicapis.org/entries').subscribe(data => {
      console.log(data);
      this.res = data;
      }
    )

    this.http.get('http://localhost:8080/baseWeb/api').subscribe(data => {
        console.log(" ------------ ")
        console.log(data);
      }
    )
    return this.res;
  }

  getBlocco(){
    this.http.get('http://localhost:8080/baseWeb/blocco').subscribe(data => {
        console.log(" ------------ blocco --------------")
        console.log(data);
      }
    )
  }
}
