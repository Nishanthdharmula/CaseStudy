import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  bookings: Booking[];

  constructor(private bookingService: BookingService,  private router: Router) { }

  ngOnInit(): void {
    this.getBookings();
  }
  private getBookings() {
    this.bookingService.getBookingsList().subscribe(data => {
      this.bookings = data;
    });
  }

  updateBooking(id: number){
    this.router.navigate(['update-flight', id]);
  }

  deleteBooking(id: number){
    this.bookingService.deleteBooking(id).subscribe(data => {
      console.log(data);
      this.getBookings();
    })
  }

}
