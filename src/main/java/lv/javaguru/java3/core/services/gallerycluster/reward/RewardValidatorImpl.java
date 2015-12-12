package lv.javaguru.java3.core.services.gallerycluster.reward;

import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;
import lv.javaguru.java3.core.services.gallerycluster.Validator;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class RewardValidatorImpl extends Validator implements RewardValidator{

    private final String BASE = "Reward ";

    @Override
    public void validate(String name, String label, String description, boolean isActive) {

        validateText(name, BASE + "name");
        validateText(label, BASE + "label");
        validateText(description, BASE + "description");
        validateState(isActive, BASE + "active state");

    }

    private void validateLabel(String label) {

    }

    @Override
    public void validate(RewardDTO rewardDTO) {
        validateText(rewardDTO.getName(), BASE + "name");
        validateText(rewardDTO.getLabel(), BASE + "label");
        validateText(rewardDTO.getDescription(), BASE + "description");
        validateState(rewardDTO.isActive(), BASE + "active state");
    }
}
