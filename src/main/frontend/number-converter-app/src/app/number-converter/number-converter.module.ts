import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NumberConverterComponent } from './components/number-converter/number-converter.component';
import {NumberConverterRoutingModule} from "./routing/number-converter-routing.module";
import {SharedModule} from "../shared";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    NumberConverterComponent
  ],
  imports: [
    CommonModule,
    NumberConverterRoutingModule,
    SharedModule,
    MatGridListModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatCardModule,
    MatSnackBarModule
  ]
})
export class NumberConverterModule { }
