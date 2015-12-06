package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.user.ChangePasswordDTO;

public class ChangePasswordCommand implements DomainCommand<ChangePasswordResult> {

    private final ChangePasswordDTO changePasswordDTO;

    public ChangePasswordCommand(ChangePasswordDTO changePasswordDTO) {
        this.changePasswordDTO = changePasswordDTO;
    }

    public ChangePasswordDTO getChangePasswordDTO() {
        return changePasswordDTO;
    }
}
