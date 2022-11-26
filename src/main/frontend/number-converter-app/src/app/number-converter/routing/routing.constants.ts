import {Route} from '@angular/router';
import {NumberConverterComponent} from '../components/number-converter/number-converter.component';
import {MainLayoutComponent} from "../../shared";

export const routes: Array<Route> = [
  {
    path: '',
    component: MainLayoutComponent,
    children: [{path: '', component: NumberConverterComponent}]
  },
];
