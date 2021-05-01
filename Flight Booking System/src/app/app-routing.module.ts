import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { BookingComponent } from './booking/booking.component';
import { BoookingSuccessfulComponent } from './boooking-successful/boooking-successful.component';
import { CancrlledSuvvessfullyComponent } from './cancrlled-suvvessfully/cancrlled-suvvessfully.component';
import { FlightsListComponent } from './flights-list/flights-list.component';
import { HomeComponent } from './home/home.component';
import { LogComponent } from './log/log.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ReviewListComponent } from './review-list/review-list.component';
import { ReviewComponent } from './review/review.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';


import { UpdateFlightComponent } from './update-flight/update-flight.component';

const routes: Routes = [
  /*{path: '/', redirectTo: 'flights', pathMatch: 'full'},*/
  {path: '', component: HomeComponent },
  {path: 'log', component: LogComponent},
  {path: 'review', component: ReviewComponent},
  {path: 'review-list', component: ReviewListComponent},
  {path: 'Booking-list', component: BookingListComponent},
  {path: 'Booking', component: BookingComponent},
  {path: 'cancel', component: CancrlledSuvvessfullyComponent},
  {path: 'conform-booking', component: BoookingSuccessfulComponent},
  {path: 'flights', component: FlightsListComponent},
  {path: 'add-flight', component: AddFlightComponent},
  {path: 'search-flight', component: SearchFlightComponent},
  {path: 'update-flight/:id', component: UpdateFlightComponent},
  {path: 'login', component: LoginFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
