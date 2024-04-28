import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  posts: any[] = [];

  constructor(
    private apiService: ApiService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.fetchAllPosts();
  }

  fetchAllPosts(): void {
    this.apiService.getAllPosts().subscribe(
      (response: any[]) => {
        console.log(response);
        this.posts = response;
      },
      (error) => {
        console.error('Error fetching posts:', error);
      },
    );
  }

  viewPost(postId: string): void {
    this.router.navigate(['/post', postId]);
  }

  upvotePost(postId: string): void {
    this.apiService.upvotePost(postId).subscribe(
      () => {
        const index = this.posts.findIndex((post) => post.id === postId);
        if (index !== -1) {
          this.posts[index].upVote++;
          this.posts[index].hasVoted = true;
        }
      },
      (error) => {
        console.error('Error upVoting post:', error);
      },
    );
  }
}
