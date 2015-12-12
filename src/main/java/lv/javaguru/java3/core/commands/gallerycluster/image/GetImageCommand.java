package lv.javaguru.java3.core.commands.gallerycluster.image;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetImageCommand implements DomainCommand<GetImageResult> {
    private final long id;

    public GetImageCommand(long id){
        this.id = id;
    }

    public long getImageId(){
        return id;
    }
}
