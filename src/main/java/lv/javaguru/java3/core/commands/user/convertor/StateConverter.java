package lv.javaguru.java3.core.commands.user.convertor;

import lv.javaguru.java3.core.domain.user.State;
import lv.javaguru.java3.core.dto.user.StateDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.user.StateDTOBuilder.createStateDTO;
import static lv.javaguru.java3.core.domain.user.StateBuilder.createState;

@Component
public class StateConverter {

    public StateDTO convert(State state) {
        if (state==null) return null;
        return createStateDTO()
                .withId(state.getId())
                .withState(state.getState())
                .build();
    }

    public State convert(StateDTO stateDTO) {
        if (stateDTO==null) return null;
        return createState()
                .withId(stateDTO.getId())
                .withState(stateDTO.getState())
                .build();
    }

}