import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';
import { Router }  from '@angular/router';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {

  flights: Flight[];

  /*searchFlightName:string="";*/

  searchFrom:string="";

  searchTo:string="";

  searchDate:string="";

  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit(): void {
    this.getFlights();
  }
  private getFlights() {
    this.flightService.getFlightsList().subscribe(data => {
      this.flights = data;
    });
  }

  /*onSubmit(){
    console.log(this.flight);*/
    /*this.saveFlight();*/

  /*}*/


}
