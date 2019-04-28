import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { FeatureRequestService } from '../feature-request.service';
import { FeatureRequest } from '../featureRequest';

@Component({
  selector: 'app-feature-detail',
  templateUrl: './feature-detail.component.html',
  styleUrls: ['./feature-detail.component.css']
})
export class FeatureDetailComponent implements OnInit {

  req: FeatureRequest;
  
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private reqService: FeatureRequestService
    ) { }

  ngOnInit(): void{
    this.getReq();
  }

  getReq(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reqService.getFeatureRequest(id)
      .subscribe(req => this.req = req);
  }

  goBack(): void{
    this.location.back();
  }

}
