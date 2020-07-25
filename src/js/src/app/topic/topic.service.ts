import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TopicModel } from './topic-response';

@Injectable({
  providedIn: 'root',
})
export class TopicService {
  constructor(private http: HttpClient) {}

  getAllTopics(): Observable<Array<TopicModel>> {
    return this.http.get<Array<TopicModel>>(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/topic'
    );
  }

  createTopic(topicModel: TopicModel): Observable<TopicModel> {
    return this.http.post<TopicModel>(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/topic',
      topicModel
    );
  }
}
