import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { registerLocaleData } from '@angular/common';
import localFr from '@angular/common/locales/fr';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ExpenseListComponent } from './expense/expense-list/expense-list.component';
import { AppRoutingModule } from './app-routing.module';


registerLocaleData(localFr, 'fr');


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ExpenseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
