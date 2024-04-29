import { Component, Input } from '@angular/core';
import { PostDTO } from '../model/postDTO';
import { ApiService } from '../service/api.service';
import { HomeComponent } from '../home/home.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css'],
})
export class NewPostComponent {
  newPost: PostDTO = {
    username: '@random',
    title: '',
    description: '',
  };

  constructor(private api: ApiService, private home: HomeComponent) {}

  submitPost(): void {
    this.newPost.username = this.newPost.username.replace(/\s/g, '');

    this.api.addNewPost(this.newPost).subscribe(
      () => {
        this.home.fetchAllPosts();
        this.newPost = {
          username: '',
          title: '',
          description: '',
        };

        console.log('New post add successfuly');
      },
      (error) => console.log(this.newPost, error)
    );
  }

  posted(): void {
    this.home.newPostPosted();
  }
}
