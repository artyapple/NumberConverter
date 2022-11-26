import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuditLogComponent } from './components/audit-log/audit-log.component';
import {AuditLogRoutingModule} from "./routing/audit-log-routing.module";
import {MatTableModule} from "@angular/material/table";



@NgModule({
  declarations: [
    AuditLogComponent
  ],
  imports: [
    CommonModule,
    AuditLogRoutingModule,
    MatTableModule
  ]
})
export class AuditLogModule { }
