package com.xalio.speakyourmind.post;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

	private UUID id;

	@NotNull
	@NotBlank
	private String username;

	@NotNull
	@NotBlank
	private String title;
	@NotNull
	@NotBlank
	private String description;

	@CreatedDate
	private LocalDateTime createdAt;

	private Integer upVote;
	private boolean hasVoted;

}
