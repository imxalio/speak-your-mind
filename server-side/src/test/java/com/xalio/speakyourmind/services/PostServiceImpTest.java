package com.xalio.speakyourmind.services;

import com.xalio.speakyourmind.comment.CommentDTO;
import com.xalio.speakyourmind.post.Post;
import com.xalio.speakyourmind.post.PostDTO;
import com.xalio.speakyourmind.post.PostRepository;
import com.xalio.speakyourmind.post.PostServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PostServiceImpTest {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	PostServiceImp postServiceImp;

	@Test
	void testGetAllPosts() {
		assertThat(postServiceImp.getAllPosts()).isNotEmpty();
		assertThat(postServiceImp.getAllPosts()
		                         .size()).isEqualTo(4);
	}

	@Test
	void testGetPostById() throws NotFoundException {
		Post post = postRepository.findAll()
		                          .get(0);
		PostDTO getPost = postServiceImp.getPostById(post.getId());
		assertThat(getPost).isNotNull();
	}

	@Test
	void testNewPost() {
		PostDTO postDTO = PostDTO.builder()
		                         .title("test posting")
		                         .description("test posting with description")
		                         .build();
		postServiceImp.newPost(postDTO);
		List<PostDTO> allPosts = postServiceImp.getAllPosts();
		assertThat(allPosts).isNotEmpty();
		assertThat(allPosts).anyMatch(post ->
				                              post.getTitle()
				                                  .equals(postDTO.getTitle()) &&
						                              post.getDescription()
						                                  .equals(postDTO.getDescription()));
	}

	@Test
	void testNewComment() throws NotFoundException {
		Post post = postRepository.findAll()
		                          .get(0);
		CommentDTO commentDTO = CommentDTO.builder()
		                                  .content("First comment here")
		                                  .build();
		postServiceImp.newComment(post.getId(), commentDTO);
		Post postAfterComment = postRepository.findById(post.getId())
		                                      .get();
		assertThat(postAfterComment.getCommentList()).isNotEmpty();
		assertThat(postAfterComment.getCommentList()
		                           .get(0)
		                           .getContent()).isEqualTo(commentDTO.getContent());
	}

	@Test
	void testPatchPostUpVote() throws NotFoundException {
		Post post = postRepository.findAll()
		                          .get(0);
		postServiceImp.patchPostUpVote(post.getId());
		Post postAfterUpVote = postRepository.findById(post.getId())
		                                     .get();
		assertThat(postAfterUpVote.getUpVote()).isEqualTo(post.getUpVote() + 1);
	}


}