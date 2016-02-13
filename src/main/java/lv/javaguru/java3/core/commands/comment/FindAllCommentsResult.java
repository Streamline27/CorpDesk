package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.comment.CommentDTO;

import java.util.List;

/**
 * Created by svetlana on 13/02/16.
 */
public class FindAllCommentsResult implements DomainCommandResult {

    private List<CommentDTO> commentDTOList;

    public FindAllCommentsResult(List<CommentDTO> commentDTOList) {
        this.commentDTOList = commentDTOList;
    }

    public List<CommentDTO> getCommentDTOList() {
        return commentDTOList;
    }
}
