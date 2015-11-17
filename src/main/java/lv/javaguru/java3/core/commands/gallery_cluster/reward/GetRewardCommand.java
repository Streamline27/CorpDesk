package lv.javaguru.java3.core.commands.gallery_cluster.reward;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetRewardCommand implements DomainCommand<GetRewardResult> {
    private final long id;

    public GetRewardCommand(long id){
        this.id = id;
    }

    public long getRewardId(){
        return id;
    }
}
