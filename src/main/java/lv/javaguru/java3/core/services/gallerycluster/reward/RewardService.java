package lv.javaguru.java3.core.services.gallerycluster.reward;

import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface RewardService {
    Reward update(Long id,
                 String newName,
                 String newLabel,
                 String newDescription,
                 boolean newIsActive);

    Reward get(Long id);

    Reward update(Reward reward);

    RewardDTO update(RewardDTO rewardDTO);

    void delete(long id);

}
