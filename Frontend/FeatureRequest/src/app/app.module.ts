import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FeatureRequestsComponent } from './feature-requests/feature-requests.component';
import { FeatureDetailComponent } from './feature-detail/feature-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    FeatureRequestsComponent,
    FeatureDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
