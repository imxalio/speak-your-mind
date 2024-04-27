package com.xalio.speakyourmind.controller;


import com.xalio.speakyourmind.dto.CommentDTO;
import com.xalio.speakyourmind.dto.PostDTO;
import com.xalio.speakyourmind.services.PostServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post/")
@RequiredArgsConstructor
public class PostController {

	private final PostServiceImp postServiceImp;

	@GetMapping
	public List<PostDTO> getAllPosts() {
		return postServiceImp.getAllPosts();
	}

	@GetMapping("{id}")
	public PostDTO getPostById(@PathVariable("id") UUID id) throws ChangeSetPersister.NotFoundException {
		return postServiceImp.getPostById(id);
	}

	@PostMapping
	public void newPost(@RequestBody PostDTO postDTO) {
		postServiceImp.newPost(postDTO);
	}

	@PostMapping("{id}/comment")
	public void newComment(@PathVariable("id") UUID id, @RequestBody CommentDTO commentDTO) throws ChangeSetPersister.NotFoundException {
		postServiceImp.newComment(id, commentDTO);
	}

	@PostMapping("{id}")
	public void newUpVote(@PathVariable("id") UUID id) throws ChangeSetPersister.NotFoundException {
		postServiceImp.patchPostUpVote(id);
	}
}
