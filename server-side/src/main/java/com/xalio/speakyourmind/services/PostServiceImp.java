package com.xalio.speakyourmind.services;


import com.xalio.speakyourmind.dto.CommentDTO;
import com.xalio.speakyourmind.dto.PostDTO;
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
		                     .collect(Collectors.toList());
	}

	public PostDTO getPostById(UUID id) throws NotFoundException {
		return postMapper.postToPostDto(postRepository.findById(id)
		                                              .orElseThrow(NotFoundException::new));
	}

	public void newPost(PostDTO postDTO) {
		postDTO.setUpVote(1);
		postRepository.save(postMapper.postDtoToPost(postDTO));

	}

	public void newComment(UUID id, CommentDTO commentDTO) throws NotFoundException {
		PostDTO post = getPostById(id);
		post.getCommentList()
		    .add(commentMapper.commentDtoToComment(commentDTO));
		postRepository.save(postMapper.postDtoToPost(post));
	}

	public void patchPostUpVote(UUID id) throws NotFoundException {
		PostDTO post = getPostById(id);
		post.setUpVote(post.getUpVote() + 1);
		postRepository.save(postMapper.postDtoToPost(post));
	}
}
