package com.xalio.speakyourmind.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class Post {

	@Id
	@UuidGenerator
	private UUID id;

	@NotNull
	@NotBlank
	private String title;
	@NotNull
	@NotBlank
	private String description;

	@CreatedDate
	@Column(columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> commentList;

	private Integer upVote;

}
