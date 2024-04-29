import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../service/api.service';
import { NewPostComponent } from '../new-post/new-post.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  posts: any[] = [];
  posted: boolean = false;

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit(): void {
    this.fetchAllPosts();
  }

  fetchAllPosts(): void {
    this.apiService.getAllPosts().subscribe(
      (response: any[]) => {
        this.posts = response;
      },
      (error) => {
        console.error('Error fetching posts:', error);
      }
    );
  }

  viewPost(postId: string): void {
    this.router.navigate(['/post', postId]);
  }

  upvotePost(postId: string): void {
    this.apiService.upvotePost(postId).subscribe(
      () => {
        this.fetchAllPosts();
        const index = this.posts.findIndex((post) => post.id === postId);
        if (index !== -1) {
          this.posts[index].upVote++;
          this.posts[index].hasVoted = true;
        }
      },
      (error) => {
        console.error('Error upVoting post:', error);
      }
    );
  }

  newPostPosted(): void {
    this.posted = true;
  }

  closeForm(): void {
    this.posted = false;
  }
}
