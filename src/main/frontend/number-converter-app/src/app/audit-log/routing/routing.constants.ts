import {Route} from '@angular/router';
import {AuditLogComponent} from '../components/audit-log/audit-log.component';
import {MainLayoutComponent} from "../../shared";

export const routes: Array<Route> = [
{
  path: '',
    component: MainLayoutComponent,
  children: [{path: '', component: AuditLogComponent}]
},
];
