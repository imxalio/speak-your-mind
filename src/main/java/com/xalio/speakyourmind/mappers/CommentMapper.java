package com.xalio.speakyourmind.mappers;

import com.xalio.speakyourmind.dto.CommentDTO;
import com.xalio.speakyourmind.entity.Comment;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {
	Comment commentDtoToComment(CommentDTO commentDTO);
}
