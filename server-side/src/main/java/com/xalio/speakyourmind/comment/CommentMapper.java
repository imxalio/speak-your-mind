package com.xalio.speakyourmind.comment;

import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {
	Comment commentDtoToComment(CommentDTO commentDTO);

	CommentDTO commentToCommentDto(Comment comment);
}
