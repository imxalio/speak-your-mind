package com.xalio.speakyourmind.services;


import com.xalio.speakyourmind.dto.CommentDTO;
import com.xalio.speakyourmind.dto.PostDTO;
import com.xalio.speakyourmind.entity.Post;
import com.xalio.speakyourmind.mappers.CommentMapper;
import com.xalio.speakyourmind.mappers.PostMapper;
import com.xalio.speakyourmind.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp {

	private final PostRepository postRepository;
	private final PostMapper postMapper;
	private final CommentMapper commentMapper;


	public List<PostDTO> getAllPosts() {
		return postRepository.findAll()
		                     .stream()
		                     .map(postMapper::postToPostDto)
		                     .collect(Collectors.toUnmodifiableList());
	}

	public Post getPostById(UUID id) throws NotFoundException {
		return postRepository.findById(id)
		                     .orElseThrow(NotFoundException::new);
	}

	public void newPost(PostDTO postDTO) {
		postRepository.save(postMapper.postDtoToPost(postDTO));

	}

	public void newComment(UUID id, CommentDTO commentDTO) throws NotFoundException {
		Post post = getPostById(id);
		post.getCommentList()
		    .add(commentMapper.commentDtoToComment(commentDTO));
		postRepository.save(post);
	}
}
