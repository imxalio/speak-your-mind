import { Component } from '@angular/core';
import { PostDTO } from '../model/postDTO';
import { ApiService } from '../service/api.service';
import { HomeComponent } from '../home/home.component';

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
    this.api.addNewPost(this.newPost).subscribe(
      () => {
        this.home.fetchAllPosts();
        console.log('New post add successfuly');
      },
      (error) => console.log(this.newPost, error)
    );
  }
}
