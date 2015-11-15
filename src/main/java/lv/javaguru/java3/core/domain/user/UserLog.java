package lv.javaguru.java3.core.domain.user;

import lv.javaguru.java3.core.domain.Generic;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_log")
public class UserLog extends Generic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "access_time")
    private Date accessTime;

    @Column(name = "success")
    private Boolean success;

       @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
