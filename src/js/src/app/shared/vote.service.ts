import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { VotePayload } from './vote-button/vote-payload';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VoteService {
  constructor(private http: HttpClient) {}

  vote(votePayload: VotePayload): Observable<any> {
    return this.http.post(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/votes/',
      votePayload
    );
  }
}
