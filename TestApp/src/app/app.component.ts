import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showConfig = true;

  toggleConfig() { this.showConfig = !this.showConfig; }
  // Create an Observable out of a promise
  // const apiData = ajax('http://localhost:8181/Project2/hello.do');
  // apiData.subscribe(res=> console.log(resizeBy.status, res.response));

  // title = this.http.get("http://localhost:8181/Project2/hello.do");
  // public post () {
  //    this.http.post("http://localhost:8181/test/do", (new Headers({ 'Content-Type': 'text/plain' })));
  //  }
}
