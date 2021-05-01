import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  booking: Booking = new Booking();

  constructor(private bookingService: BookingService, private router: Router) { }

  ngOnInit(): void {
  }

  saveBooking(){
    this.bookingService.createBooking(this.booking).subscribe( data => {
      console.log(data);
      this.gotoBookingDetails();
    },
    error => console.log(error));
  }

  gotoBookingDetails(){
    this.router.navigate(['./bookings'])
  }

  onSubmit(){
    console.log(this.booking);
    this.saveBooking();

}
}
