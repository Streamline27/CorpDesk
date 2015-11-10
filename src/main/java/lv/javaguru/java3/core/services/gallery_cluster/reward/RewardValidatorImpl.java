package lv.javaguru.java3.core.services.gallery_cluster.reward;

import lv.javaguru.java3.core.services.gallery_cluster.Validator;

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
}
