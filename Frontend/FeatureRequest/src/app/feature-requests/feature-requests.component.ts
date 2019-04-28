import { Component, OnInit } from '@angular/core';

import { FeatureRequest } from '../featureRequest';
import { FeatureRequestService } from '../feature-request.service';

@Component({
  selector: 'app-feature-requests',
  templateUrl: './feature-requests.component.html',
  styleUrls: ['./feature-requests.component.css']
})
export class FeatureRequestsComponent implements OnInit {

  reqs: FeatureRequest[];
  //selectedReq: mockFeatureReq;

  constructor(private reqService: FeatureRequestService) { }

  ngOnInit() {
    this.getFeatureRequests();
  }
  
  getFeatureRequests(): void {
    this.reqService.getFeatureRequests()
      .subscribe(reqs => this.reqs = reqs);
  }

 /** onSelect(req: mockFeatureReq): void {
  *  this.selectedReq = req;
  *}
  */
}
