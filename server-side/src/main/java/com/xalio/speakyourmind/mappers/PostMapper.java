package com.xalio.speakyourmind.mappers;


import com.xalio.speakyourmind.dto.PostDTO;
import com.xalio.speakyourmind.entity.Post;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
	Post postDtoToPost(PostDTO postDTO);

	PostDTO postToPostDto(Post post);
}
