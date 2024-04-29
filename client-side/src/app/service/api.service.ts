import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, shareReplay } from 'rxjs';
import { PostDTO } from '../model/postDTO';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl =
    'https://speak-deployement-bf22fd40353e.herokuapp.com/api/v1/post';

  constructor(private http: HttpClient) {}

  getAllPosts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/`).pipe(shareReplay());
  }

  addNewPost(content: PostDTO): Observable<any> {
    return this.http.post<any[]>(`${this.baseUrl}/new`, content);
  }

  getPostById(postId: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${postId}`);
  }

  upvotePost(postId: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/vote/${postId}`, {});
  }

  getCommentsForPost(postId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/${postId}/comments`);
  }

  addCommentToPost(postId: string, content: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/${postId}/comment`, content);
  }
}
