package lv.javaguru.java3.core.services.gallerycluster.reward;

import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface RewardFactory {
    Reward create( String name,
                    String label,
                    String description,
                    boolean isActive);

    RewardDTO create(RewardDTO rewardDTO);
}
