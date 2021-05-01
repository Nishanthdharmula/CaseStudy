import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private baseURL = "http://localhost:8030/findAllFlights";
  constructor(private httpClient: HttpClient) { }

  getFlightsList(): Observable<Flight[]>{
    return this.httpClient.get<Flight[]>(`${this.baseURL}`);
  }

  private baseURL1 = "http://localhost:8030/addFlight";
  

  createFlight(flight: Flight): Observable<Object>{
    return this.httpClient.post(`${this.baseURL1}`, flight);
  }

  getFlightById(id: number): Observable<Flight>{
    return this.httpClient.get<Flight>(`${this.baseURL}/${id}`);
  }


  private baseURL2 = "http://localhost:8030/flights";
  updateFlight(id: number, flight: Flight): Observable<Object>{
    return this.httpClient.put(`${this.baseURL2}/${id}`, flight);
  }

  private baseURL3 = "http://localhost:8030/delete";
  deleteFlight(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL3}/${id}`);
  }
  }
