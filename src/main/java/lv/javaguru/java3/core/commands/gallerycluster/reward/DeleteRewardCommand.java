package lv.javaguru.java3.core.commands.gallerycluster.reward;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteRewardCommand implements DomainCommand<DeleteRewardResult> {
    private final long id;

    public DeleteRewardCommand(long id){
        this.id = id;
    }

    public long getRewardId(){
        return id;
    }
}
