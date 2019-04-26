import { Component, OnInit } from '@angular/core';

import { FeatureRequest } from '../featureRequest';
import { mockFeatureReq } from '../mockfeatureReq';
import { MOCKFEATUREREQUESTS } from '../mockFeatureRequests';

@Component({
  selector: 'app-feature-requests',
  templateUrl: './feature-requests.component.html',
  styleUrls: ['./feature-requests.component.css']
})
export class FeatureRequestsComponent implements OnInit {

  reqs = MOCKFEATUREREQUESTS;
  selectedReq: mockFeatureReq;

  constructor() { }

  ngOnInit() {
  }

  onSelect(req: mockFeatureReq): void {
    this.selectedReq = req;
  }
}
