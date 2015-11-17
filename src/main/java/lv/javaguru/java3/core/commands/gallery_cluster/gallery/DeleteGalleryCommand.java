package lv.javaguru.java3.core.commands.gallery_cluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteGalleryCommand implements DomainCommand<DeleteGalleryResult> {
    private final long id;

    public DeleteGalleryCommand(long id){
        this.id = id;
    }

    public long getGalleryId(){
        return id;
    }
}
