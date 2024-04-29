import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from './../service/api.service';
import { Post } from '../model/post';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css'],
})
export class PostDetailComponent implements OnInit {
  post: Post = {
    id: '',
    title: '',
    description: '',
    username: '',
    createdAt: new Date(),
    upVote: 1,
    hasVoted: false,
  };

  constructor(private route: ActivatedRoute, private apiService: ApiService) {}

  ngOnInit(): void {
    this.fetchPostDetails();
  }

  fetchPostDetails(): void {
    const postId = this.route.snapshot.paramMap.get('id');
    if (postId) {
      this.apiService.getPostById(postId).subscribe(
        (response: any) => {
          this.post = response;
        },
        (error) => {
          console.error('Error fetching post details:', error);
        }
      );
    }
  }

  upvotePost(): void {
    this.apiService.upvotePost(this.post.id).subscribe(
      () => {
        this.post.hasVoted = true;
        this.post.upVote++;
      },
      (error) => {
        console.error('Error upVoting post:', error);
      }
    );
  }
}
