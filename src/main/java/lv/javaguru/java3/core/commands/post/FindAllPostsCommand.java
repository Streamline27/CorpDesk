package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by svetlana on 13/02/16.
 */
public class FindAllPostsCommand implements DomainCommand<FindAllPostsResult> {

    private int page;

    private int size;

    public FindAllPostsCommand(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
