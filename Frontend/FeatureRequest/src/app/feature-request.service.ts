import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { FeatureRequest } from './featureRequest';
import { Client } from './client';
import { ProductArea } from './productArea'
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FeatureRequestService {
  private feaReqAPIBaseURL = 'http://localhost:8080/wcfFeatureRequest/api/rest';


  constructor(
    private http: HttpClient,
    private msgService: MessageService) { }

    /** GET operations */
  getFeatureRequests(): Observable<FeatureRequest[]> {
    return this.http.get<FeatureRequest[]>(this.feaReqAPIBaseURL + '/featureRequests')
    .pipe(
      // tap(_ => this.log('fetched featureRequests')),
      catchError(this.handleError<FeatureRequest[]>('getFeatureRequests', []))
    );
  }
  getFeatureRequest(id: number): Observable<FeatureRequest>{
    return this.http.get<FeatureRequest>(this.feaReqAPIBaseURL + `/featureRequests/${id}`)
    .pipe(
      // tap(_ => this.log(`fetched featureRequest id=${id}`)),
      catchError(this.handleError<FeatureRequest>(`getFeatureRequest id=${id}`))
    )
  }
  getClientList(): Observable<Client[]>{
    return this.http.get<Client[]>(this.feaReqAPIBaseURL + '/clients')
    .pipe(
      // tap(_ => this.log('fetched client list')),
      catchError(this.handleError<Client[]>('getClientList failed'))
    )
  }
  getProductAreaList(): Observable<ProductArea[]>{
    return this.http.get<ProductArea[]>(this.feaReqAPIBaseURL + '/productAreas')
    .pipe(
      // tap(_ => this.log('fetched product area list')),
      catchError(this.handleError<ProductArea[]>('getProductAreaList failed'))
    )
  }

  /** PUT operations */
  updateFeatureRequest(req: FeatureRequest): Observable<any> {
    return this.http.put<FeatureRequest>(this.feaReqAPIBaseURL + '/featureRequests', req, httpOptions)
    .pipe(
      // tap(_ => this.log(`Updated featureRequest id=${req.requestID}`)),
      catchError(this.handleError<FeatureRequest>(`updateRequest id=${req.requestID}`))
    )
  }

  /** POST operations */
  addFeatureRequest(newReq: FeatureRequest): Observable<any>{
    return this.http.post<FeatureRequest>(this.feaReqAPIBaseURL + '/featureRequests', newReq, httpOptions)
    .pipe(
      // tap(_ => this.log(`Created new featureRequest title=${newReq.title}`)),
      catchError(this.handleError<FeatureRequest>(`addFeatureRequest title=${newReq.title}`))
    )
  }

  /** DELETE operations */
  deleteFeatureRequest(req: FeatureRequest | number): Observable<any>{
    const id = typeof req ==='number' ? req : req.requestID;

    return this.http.delete<FeatureRequest>(this.feaReqAPIBaseURL + `/featureRequests/${id}`, httpOptions)
    .pipe(
      // tap(_ => this.log(`Deleted feature request id=${id}`)),
      catchError(this.handleError<FeatureRequest>(`deleteFeatureRequest id=${id}`))
    )
  }

  private log(message: string){
    this.msgService.add(`FeatureRequestService: ${message}`);
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T> (operation = 'operation', result?: T){
    return (error: any): Observable<T> => {
      //TODO: send error to remote logging infrastructure
      console.error(error); //log to console instead

      //TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      //let thte app keep running by returning an empty result
      return of(result as T);
    }
  }
}
