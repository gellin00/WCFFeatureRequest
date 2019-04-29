import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FeatureRequestsComponent } from './feature-requests/feature-requests.component';
import { FeatureDetailComponent } from './feature-detail/feature-detail.component';
import { FeatureAddComponent } from './feature-add/feature-add.component';

const routes: Routes = [
  { path: '', redirectTo: '/featureRequests', pathMatch: 'full'},
  { path: 'featureRequests', component: FeatureRequestsComponent},
  { path: 'featureDetails/:id', component: FeatureDetailComponent},
  { path: 'newFeature', component: FeatureAddComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
