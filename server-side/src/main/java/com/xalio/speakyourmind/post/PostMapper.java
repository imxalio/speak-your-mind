package com.xalio.speakyourmind.post;


import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
	Post postDtoToPost(PostDTO postDTO);

	PostDTO postToPostDto(Post post);
}
