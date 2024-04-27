package com.xalio.speakyourmind.dto;


import com.xalio.speakyourmind.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PostDTO {

	private UUID id;

	@NotNull
	@NotBlank
	private String title;
	@NotNull
	@NotBlank
	private String description;

	@CreatedDate
	private LocalDateTime createdAt;

	private List<Comment> commentList;

	private Integer upVote;
	
}
