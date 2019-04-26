import { Component, OnInit, Input } from '@angular/core';

import { FeatureRequest } from '../featureRequest';
import { mockFeatureReq } from '../mockfeatureReq';

@Component({
  selector: 'app-feature-detail',
  templateUrl: './feature-detail.component.html',
  styleUrls: ['./feature-detail.component.css']
})
export class FeatureDetailComponent implements OnInit {

  @Input() req: mockFeatureReq;
  
  constructor() { }

  ngOnInit() {
  }

}
