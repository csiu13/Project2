import { NgModule }         from '@angular/core';
import { BrowserModule }    from '@angular/platform-browser';
import { FormsModule }      from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientXsrfModule } from '@angular/common/http';


import { AppComponent }         from './app.component';

import { ConfigComponent }      from './config/config.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    // import HttpClientModule after BrowserModule.
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'My-Xsrf-Cookie',
      headerName: 'My-Xsrf-Header',
    }),

  ],
  declarations: [
    AppComponent,
    ConfigComponent,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}

