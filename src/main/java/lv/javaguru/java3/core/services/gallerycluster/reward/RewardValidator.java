package lv.javaguru.java3.core.services.gallerycluster.reward;

import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface RewardValidator {
    void validate(String name,
                  String label,
                  String description,
                  boolean isActive);
    void validate(RewardDTO rewardDTO);
}
