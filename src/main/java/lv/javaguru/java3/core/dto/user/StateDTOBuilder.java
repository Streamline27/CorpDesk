package lv.javaguru.java3.core.dto.user;

public class StateDTOBuilder {

    private long id;
    private String state;

    private StateDTOBuilder() {}

    public static StateDTOBuilder createStateDTO() { return new StateDTOBuilder(); }

    public StateDTO build() {

        StateDTO stateDTO  = new StateDTO();
        stateDTO.setId(id);
        stateDTO.setState(state);

        return stateDTO;

    }

    public StateDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public StateDTOBuilder withState(String state) {
        this.state = state;
        return this;
    }
}
