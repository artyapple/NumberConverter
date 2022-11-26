import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {ConverterService} from "../../services/converter.service";
import {ConvertRequest} from "../../models/convert-request";
import {BehaviorSubject} from "rxjs";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-number-converter',
  templateUrl: './number-converter.component.html',
  styleUrls: ['./number-converter.component.scss']
})
export class NumberConverterComponent implements OnInit{
  formGroup!: FormGroup;
  result$: BehaviorSubject<string> = new BehaviorSubject<string>('');

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly convService: ConverterService,
    private readonly snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      inputType: [null,[Validators.required]],
      value: [null,[Validators.required]],
      outputType: [null,[Validators.required]]
    });
    const inputTypeControl = this.formGroup.get('inputType');
    const valueControl = this.formGroup.get('value');
    const binaryValidator = this.validateBinaryValue();
    inputTypeControl?.valueChanges.subscribe(value=>{
      if(value==='BINARY'){
        valueControl?.addValidators(binaryValidator);
      } else {
        valueControl?.removeValidators(binaryValidator);
      }
      valueControl?.updateValueAndValidity();
    });
  }

  validateBinaryValue(): ValidatorFn {
    return (control) => {
      const regex = /^[0-1]{1,}$/g;
      return regex.test(control.value)
        ? null
        : {
          notBinary: true
        };
    }
  }

  onConvert(): void {
    if(this.formGroup.invalid){
      return;
    }
    const request = this.formGroup.value as ConvertRequest;
    this.convService.convert(request).subscribe({
      next: (response) => {
        this.result$.next(response.result);
      },
      error: (err) => {
        this.result$.next('');
        this.snackBar.open(err.error.message, 'Close', {
          panelClass: ['error-snackbar']
        });
      }
    });
  }
}
