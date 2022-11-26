import { Component } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {AuditEntry} from "../../models/audit-entry";
import {AuditLogService} from "../../services/audit-log.service";
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-audit-log',
  templateUrl: './audit-log.component.html',
  styleUrls: ['./audit-log.component.scss']
})
export class AuditLogComponent {

  displayedColumns = ['timestamp','inputType','inputValue','outputType','outputValue'];
  dataSource$: BehaviorSubject<MatTableDataSource<AuditEntry>> = new BehaviorSubject<MatTableDataSource<AuditEntry>>(new MatTableDataSource<AuditEntry>());

  constructor(private auditService: AuditLogService) {
  }

  ngOnInit(){
    this.getAuditLogs();
  }

  getAuditLogs(){
    this.auditService.findAll()
      .subscribe((res)=>{
        this.dataSource$.next(new MatTableDataSource<AuditEntry>(res));
      })
  }

}
