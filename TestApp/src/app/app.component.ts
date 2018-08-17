import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor (private http : HttpClient) { }
  // title = JSON.stringify(http.get("http://localhost:8181/Project2/hello.do"));
  // public post () {
  //    this.http.post("http://localhost:8181/test/do", (new Headers({ 'Content-Type': 'text/plain' })));
  //  }
}
