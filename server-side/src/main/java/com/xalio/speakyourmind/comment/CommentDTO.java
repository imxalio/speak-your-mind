package com.xalio.speakyourmind.comment;

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
public class CommentDTO {


	private UUID id;

	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String content;
	@CreatedDate
	private LocalDateTime createdAt;
}
