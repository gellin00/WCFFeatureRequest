import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FeatureRequestsComponent } from './feature-requests/feature-requests.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FeatureDetailComponent } from './feature-detail/feature-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'featureRequests', component: FeatureRequestsComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'featureDetails/:id', component: FeatureDetailComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
