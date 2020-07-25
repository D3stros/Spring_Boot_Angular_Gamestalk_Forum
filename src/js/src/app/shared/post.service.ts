import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PostModel } from './post-model';
import { Observable } from 'rxjs';
import { CreatePostPayload } from 'src/app/post/create-post/create-post-payload';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  constructor(private http: HttpClient) {}

  getAllPosts(): Observable<Array<PostModel>> {
    return this.http.get<Array<PostModel>>(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/posts/'
    );
  }

  createPost(postPayload: CreatePostPayload): Observable<any> {
    return this.http.post(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/posts/',
      postPayload
    );
  }

  getPost(id: number): Observable<PostModel> {
    return this.http.get<PostModel>(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/posts/' +
        id
    );
  }

  getAllPostsByUser(name: string): Observable<PostModel[]> {
    return this.http.get<PostModel[]>(
      'http://gamestalkbackend-env.eba-c3mvh9em.eu-central-1.elasticbeanstalk.com/api/posts/by-user/' +
        name
    );
  }
}
