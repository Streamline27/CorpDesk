package lv.javaguru.java3.core.commands.gallery_cluster.image;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteImageCommand implements DomainCommand<DeleteImageResult> {
    private final long id;

    public DeleteImageCommand(long id){
        this.id = id;
    }

    public long getImageId(){
        return id;
    }
}
