import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {

  id: number;
  flight: Flight = new Flight();

  constructor(private flightService: FlightService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.flight = new Flight();
    this.id = this.route.snapshot.params['id'];

    this.flightService.getFlightById(this.id).subscribe(data => {
      console.log(data)
      this.flight = data;
    }, error => console.log(error));
  }

  updateFlight(){
    this.flightService.updateFlight(this.id, this.flight).subscribe( data =>{
      console.log(data);
      this.flight = new Flight();
      this.gotoFlightList();
    }, error  => console.log(error));
  }

  onSubmit(){
    this.updateFlight();
  }

  gotoFlightList() {
    this.router.navigate(['/flights']);
  }

  }

  /*onSubmit(){
    this.flightService.updateFlight(this.id, this.flight).subscribe( data =>{
      this.goToFlightList();
    }, error  => console.log(error));
  }

  goToFlightList(){
    this.router.navigate(['/employees']);
  }*/


