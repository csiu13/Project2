import { Component } from '@angular/core';
import { Config, ConfigService } from './config.service';


@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  providers: [ ConfigService ],
  styles: ['.error {color: red;}']
})

export class ConfigComponent {
  error: any;
  headers: string[];
  message: string;
  body: string;
  config: Config;

  constructor(private configService: ConfigService) {}

  clear() {
    this.config = undefined;
    this.error = undefined;
    this.headers = undefined;
  }

  runTests() {
    return this.configService.getTestResult('?test=true')
      .subscribe(
        (data: string) => {this.body = data; console.log(data);},
        error => this.error = error
      );
  }

  showConfig() {
    return this.configService.getConfig()
      .subscribe(
        (data: string) => {this.message = data; console.log(data);}, // success path
        error => this.error = error // error path
      );
  }


  showConfigResponse() {
    this.configService.getConfigResponse()
      // resp is of type `HttpResponse<Config>`
      .subscribe(resp => {
        // display its headers
        const keys = resp.headers.keys();
        this.headers = keys.map(key =>
          `${key}: ${resp.headers.get(key)}`);

        // access the body directly, which is typed as `Config`.
        this.config = { ... resp.body };
      });
  }
  makeError() {
    this.configService.makeIntentionalError().subscribe(null, error => this.error = error );
  }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/