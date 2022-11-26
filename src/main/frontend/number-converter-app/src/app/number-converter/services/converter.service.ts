import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ConvertRequest} from '../models/convert-request';
import {Observable} from 'rxjs';
import {ConvertResponse} from '../models/convert-response';

@Injectable({
  providedIn: 'root'
})
export class ConverterService {

  constructor(private readonly http: HttpClient) {
  }

  convert(request: ConvertRequest): Observable<ConvertResponse>{
    return this.http.post<ConvertResponse>('/api/convert',request);
  }
}
