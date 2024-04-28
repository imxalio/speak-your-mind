package com.xalio.speakyourmind.services;

import com.xalio.speakyourmind.comment.CommentDTO;
import com.xalio.speakyourmind.post.Post;
import com.xalio.speakyourmind.post.PostDTO;
import com.xalio.speakyourmind.post.PostRepository;
import com.xalio.speakyourmind.post.PostServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PostServiceImpTest {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	HttpServletRequest request;


	@Autowired
	PostServiceImp postServiceImp;

	@Test
	@Transactional
	void testGetAllPosts() {
		assertThat(postServiceImp.getAllPosts()).isNotEmpty();
		assertThat(postServiceImp.getAllPosts()
		                         .size()).isEqualTo(4);
	}

	@Test
	@Transactional
	void testGetPostById() throws NotFoundException {
		Post post = postRepository.findAll()
		                          .get(0);

		PostDTO getPost = postServiceImp.getPostById(post.getId());
		assertThat(getPost).isNotNull();
		assertThat(getPost.getId()).isEqualTo(post.getId());
	}

	@Test
	@Transactional
	void testNewPost() {
		Integer length = postServiceImp.getAllPosts()
		                               .size();
		PostDTO postDTO = PostDTO.builder()
		                         .title("test posting")
		                         .username("xalio")
		                         .description("test posting with description")
		                         .build();
		postServiceImp.newPost(postDTO);
		List<PostDTO> allPosts = postServiceImp.getAllPosts();

		assertThat(allPosts).isNotEmpty();
		assertThat(allPosts.size()).isEqualTo(length + 1);
	}

	@Test
	@Transactional
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
	@Transactional
	void testPatchPostUpVote() throws NotFoundException {
		Post post = postRepository.findAll()
		                          .get(0);

		int initialVote = post.getUpVote();
		postServiceImp.patchPostUpVote(post.getId());
		Post postAfterUpVote = postRepository.findById(post.getId())
		                                     .get();

		assertThat(postAfterUpVote.getUpVote()).isEqualTo(initialVote + 1);
	}


}