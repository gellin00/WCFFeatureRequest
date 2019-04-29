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

  constructor(private reqService: FeatureRequestService) { }

  ngOnInit() {
    this.getFeatureRequests();
  }
  
  getFeatureRequests(): void {
    this.reqService.getFeatureRequests()
      .subscribe(req => this.reqs = req);
  }

  delete(req: FeatureRequest): void{
    this.reqs = this.reqs.filter(r => r !== req);
    this.reqService.deleteFeatureRequest(req).subscribe();
  }
}
