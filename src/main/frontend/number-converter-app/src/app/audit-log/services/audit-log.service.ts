import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ConvertRequest} from "../../number-converter/models/convert-request";
import {Observable} from "rxjs";
import {AuditEntry} from "../models/audit-entry";

@Injectable({
  providedIn: 'root'
})
export class AuditLogService {

  constructor(private readonly http: HttpClient) { }

  public findAll(): Observable<AuditEntry[]>{
    return this.http.get<AuditEntry[]>('/api/audit');
  }
}
