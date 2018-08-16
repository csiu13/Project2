import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = "testing";
  
  constructor (private http:HttpClient) { }
  
  post () {
    return this.http.post("http://localhost:8181/test/do", (new Headers({ 'Content-Type': 'text/plain' })));
  }
  // public test () {
  //   return this.http.post("http://localhost:8181/test/do", (new Headers({ 'Content-Type': 'text/plain' })));
  // }

}

