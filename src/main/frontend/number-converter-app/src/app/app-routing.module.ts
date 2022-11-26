import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path:'',
    loadChildren:()=>import('./number-converter').then((m)=>m.NumberConverterModule)
  },
  {
    path:'audit',
    loadChildren:()=>import('./audit-log').then((m)=>m.AuditLogModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
