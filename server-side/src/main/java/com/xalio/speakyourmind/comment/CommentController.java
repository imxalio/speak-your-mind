package com.xalio.speakyourmind.comment;


import com.xalio.speakyourmind.post.PostServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post/")
@RequiredArgsConstructor
public class CommentController {

	private final PostServiceImp postServiceImp;


	@GetMapping("{id}/comments")
	public List<CommentDTO> getCommentsByPostId(@PathVariable("id") UUID id) {
		return postServiceImp.getAllCommentsByPostId(id);
	}

	@PostMapping("{id}/comment")
	public void newComment(@PathVariable("id") UUID id, @Valid @RequestBody CommentDTO commentDTO) throws NotFoundException {
		postServiceImp.newComment(id, commentDTO);
	}
}
