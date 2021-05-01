import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';
import { Router }  from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-flights-list',
  templateUrl: './flights-list.component.html',
  styleUrls: ['./flights-list.component.css']
})
export class FlightsListComponent implements OnInit {

  flights: Flight[];

  searchFlightName:string="";

  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit(): void {
    this.getFlights();
  }
  private getFlights() {
    this.flightService.getFlightsList().subscribe(data => {
      this.flights = data;
    });
  }

  updateFlight(id: number){
    this.router.navigate(['update-flight', id]);
  }

  deleteFlight(id: number){
    this.flightService.deleteFlight(id).subscribe(data => {
      console.log(data);
      this.getFlights();
    })
  }
}
