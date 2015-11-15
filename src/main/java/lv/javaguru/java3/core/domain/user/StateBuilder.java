package lv.javaguru.java3.core.domain.user;

public class StateBuilder {

    private long id;
    private String stateName;

    private StateBuilder() {}

    public static StateBuilder createState() { return new StateBuilder(); }

    public State build() {

        State state  = new State();
        state.setId(id);
        state.setState(stateName);

        return state;
    }

    public StateBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public StateBuilder withState(String state) {
        this.stateName = state;
        return this;
    }

    public StateBuilder created() {
        this.id = 1;
        return this;
    }

    public StateBuilder modified() {
        this.id = 2;
        return this;
    }

    public StateBuilder deleted() {
        this.id = 3;
        return this;
    }

    public StateBuilder blocked() {
        this.id = 4;
        return this;
    }

}
