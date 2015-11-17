package lv.javaguru.java3.core.commands.gallery_cluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetGalleryCommand implements DomainCommand<GetGalleryResult> {
    private final long id;

    public GetGalleryCommand(long id){
        this.id = id;
    }

    public long getGalleryId(){
        return id;
    }
}
