package com.xalio.speakyourmind.post;


import jakarta.validation.Valid;
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


	@PostMapping("new")
	public void newPost(@Valid @RequestBody PostDTO postDTO) {
		postServiceImp.newPost(postDTO);
	}


	@PostMapping("vote/{id}")
	public void newUpVote(@PathVariable("id") UUID id) throws ChangeSetPersister.NotFoundException {
		postServiceImp.patchPostUpVote(id);
	}
}
