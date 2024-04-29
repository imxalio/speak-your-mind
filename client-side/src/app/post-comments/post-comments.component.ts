import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../service/api.service';
import { Comment } from '../model/comment';
import { CommentDTO } from '../model/commentDTO';

@Component({
  selector: 'app-post-comments',
  templateUrl: './post-comments.component.html',
  styleUrls: ['./post-comments.component.css'],
})
export class PostCommentsComponent implements OnInit {
  comments: Comment[] = [];
  commentDTO: CommentDTO = {
    username: '@random',
    content: '',
  };
  postId = this.route.snapshot.paramMap.get('id');

  constructor(private apiService: ApiService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.fetchComments();
  }

  fetchComments(): void {
    if (this.postId) {
      this.apiService.getCommentsForPost(this.postId).subscribe(
        (response: any) => {
          this.comments = response;
          console.log(response);
        },
        (error) => {
          console.log('Error fetching comments', error);
        }
      );
    }
  }

  addComment(): void {
    if (this.postId) {
      this.apiService.addCommentToPost(this.postId, this.commentDTO).subscribe(
        (newComment: CommentDTO) => {
          this.commentDTO = {
            content: '',
            username: '@random',
          };
          this.fetchComments();
        },
        (error) => console.log('Error posting comments', error)
      );
    }
  }
}
