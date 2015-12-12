package lv.javaguru.java3.core.dto.gallerycluster;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class RewardDTOBuilder {
    protected String label;
    protected String description;
    protected boolean isActive;
    private long id;
    private String name;

    private RewardDTOBuilder() {
    }

    public static RewardDTOBuilder aRewardDTO() {
        return new RewardDTOBuilder();
    }

    public RewardDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public RewardDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RewardDTOBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public RewardDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public RewardDTOBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public RewardDTOBuilder but() {
        return aRewardDTO().withId(id).withName(name).withLabel(label).withDescription(description).withIsActive(isActive);
    }

    public RewardDTO build() {
        RewardDTO rewardDTO = new RewardDTO();
        rewardDTO.setId(id);
        rewardDTO.setName(name);
        rewardDTO.setLabel(label);
        rewardDTO.setDescription(description);
        rewardDTO.setIsActive(isActive);
        return rewardDTO;
    }
}
