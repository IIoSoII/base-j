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
    return this.res;
  }
}
