import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from './review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private baseURL = "http://localhost:8020/addreview";
  constructor(private httpClient: HttpClient) { }

  createReview(review: Review): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, review);
  }

  private baseURL1 = "http://localhost:8020/allReviews";
  getReviewsList(): Observable<Review[]>{
    return this.httpClient.get<Review[]>(`${this.baseURL1}`);
  }
}
