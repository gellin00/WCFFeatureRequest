import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { FeatureRequestService } from '../feature-request.service';
import { FeatureRequest } from '../featureRequest';
import { Client } from '../client';
import { ProductArea } from '../productArea';

@Component({
  selector: 'app-feature-add',
  templateUrl: './feature-add.component.html',
  styleUrls: ['./feature-add.component.css']
})
export class FeatureAddComponent implements OnInit {

  req: FeatureRequest;
  clientList: Client[];
  productAreaList: ProductArea[];
  priorityList: number[] = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];

  constructor(  
    private location: Location,
    private reqService: FeatureRequestService
    ) { }

  ngOnInit(){
    this.getClientList();
    this.getProductAreaList();
    this.req = new FeatureRequest();
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

  save(): void{
    this.reqService.addFeatureRequest(this.req)
      .subscribe(() => this.goBack());
  }
}
