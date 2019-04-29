import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { FeatureRequestService } from '../feature-request.service';
import { FeatureRequest } from '../featureRequest';
import { Client } from '../client';
import { ProductArea } from '../productArea';

@Component({
  selector: 'app-feature-detail',
  templateUrl: './feature-detail.component.html',
  styleUrls: ['./feature-detail.component.css']
})
export class FeatureDetailComponent implements OnInit {

  req: FeatureRequest;
  clientList: Client[];
  productAreaList: ProductArea[];
  priorityList: number[] = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];
  
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private reqService: FeatureRequestService
    ) { }

  ngOnInit(): void{
    this.getReq();
    this.getClientList();
    this.getProductAreaList();
  }

  getReq(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reqService.getFeatureRequest(id)
      .subscribe(req => this.req = req);
  }
  
  getClientList(): void{
    this.reqService.getClientList()
    .subscribe(client => this.clientList = client);
  }

  getProductAreaList(): void{
    this.reqService.getProductAreaList()
    .subscribe(area => this.productAreaList = area);
  }

  goBack(): void{
    this.location.back();
  }

  save(newTarget: string): void{
    this.req.targetDate = new Date(newTarget);
    this.reqService.updateFeatureRequest(this.req)
      .subscribe(() => this.goBack());
  }

}
