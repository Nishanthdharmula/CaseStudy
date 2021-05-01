import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  

  private baseURL = "http://localhost:8040/booking/addBookings";
  constructor(private httpClient: HttpClient) { }

  createBooking(booking: Booking): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, booking);
  }

  private baseURL1 = "http://localhost:8040/booking/findAllBookings";
  getBookingsList(): Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`${this.baseURL1}`);
  }

  private baseURL3 = "http://localhost:8040/booking/delete";
  deleteBooking(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL3}/${id}`);
  }
}
