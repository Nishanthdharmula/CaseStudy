import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightsListComponent } from './flights-list/flights-list.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { FormsModule } from '@angular/forms';
import { LoginFormComponent } from './login-form/login-form.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { HomeComponent } from './home/home.component';
import { LogComponent } from './log/log.component';
import { FilterPipe } from './filter.pipe';
import { FlightfilterPipe } from './flightfilter.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material/material.module';
import { BookingComponent } from './booking/booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { ReviewComponent } from './review/review.component';
import { ReviewListComponent } from './review-list/review-list.component';
import { BoookingSuccessfulComponent } from './boooking-successful/boooking-successful.component';
import { CancrlledSuvvessfullyComponent } from './cancrlled-suvvessfully/cancrlled-suvvessfully.component';

@NgModule({
  declarations: [
    AppComponent,
    FlightsListComponent,
    AddFlightComponent,
    LoginFormComponent,
    SearchFlightComponent,
    UpdateFlightComponent,
    HomeComponent,
    LogComponent,
    FilterPipe,
    FlightfilterPipe,
    BookingComponent,
    BookingListComponent,
    ReviewComponent,
    ReviewListComponent,

    BoookingSuccessfulComponent,
    CancrlledSuvvessfullyComponent
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MaterialModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
