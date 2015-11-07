package lv.javaguru.java3.core.domain.user;

import java.util.Date;

public class UserLogBuilder {

    private long id;
    private long userId;
    private Date accessTime;
    private Boolean success;

    private UserLogBuilder() {
    }

    public static UserLogBuilder createUserLog() {
        return new UserLogBuilder();
    }

    public UserLog build() {

        UserLog userLog = new UserLog();
        userLog.setId(id);
        userLog.setUserId(userId);
        userLog.setAccessTime(accessTime);
        userLog.setSuccess(success);

        return userLog;
    }

    public UserLogBuilder withUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public UserLogBuilder withAccessTime(Date accessTime) {
        this.accessTime = accessTime;
        return this;
    }

    public UserLogBuilder withSuccess(Boolean success) {
        this.success = success;
        return this;
    }
}
