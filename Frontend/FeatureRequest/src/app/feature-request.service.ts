import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { FeatureRequest } from './featureRequest';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class FeatureRequestService {
  private feaReqAPIBaseURL = 'http://localhost:8080/wcfFeatureRequest/api/rest';

  constructor(
    private http: HttpClient,
    private msgService: MessageService) { }

  getFeatureRequests(): Observable<FeatureRequest[]> {
    return this.http.get<FeatureRequest[]>(this.feaReqAPIBaseURL + '/featureRequests');
  }
  getFeatureRequest(id: number): Observable<FeatureRequest>{
    return this.http.get<FeatureRequest>(this.feaReqAPIBaseURL + `/featureRequests/${id}`)
  }

  private log(message: string){
    this.msgService.add(`FeatureRequestService: ${message}`);
  }
}
