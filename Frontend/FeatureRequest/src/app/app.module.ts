import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FeatureRequestsComponent } from './feature-requests/feature-requests.component';
import { FeatureDetailComponent } from './feature-detail/feature-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { FeatureAddComponent } from './feature-add/feature-add.component';


@NgModule({
  declarations: [
    AppComponent,
    FeatureRequestsComponent,
    FeatureDetailComponent,
    MessagesComponent,
    FeatureAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
