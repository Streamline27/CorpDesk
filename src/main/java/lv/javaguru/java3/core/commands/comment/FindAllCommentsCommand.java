package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by svetlana on 13/02/16.
 */
public class FindAllCommentsCommand implements DomainCommand<FindAllCommentsResult> {

    private int page;
    private int size;

    public FindAllCommentsCommand(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }
}
