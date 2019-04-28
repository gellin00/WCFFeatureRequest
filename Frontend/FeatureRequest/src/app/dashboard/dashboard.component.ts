import { Component, OnInit } from '@angular/core';
import { FeatureRequest } from '../featureRequest';
import { FeatureRequestService } from '../feature-request.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  reqs: FeatureRequest[] = [];

  constructor(private reqService: FeatureRequestService) { }

  ngOnInit() {
    this.getFeatureRequests();
  }

  getFeatureRequests(): void {
    this.reqService.getFeatureRequests()
      .subscribe(reqs => this.reqs = reqs.slice(1, 5));
  }

}
