package lv.javaguru.java3.core.services.gallerycluster;

import java.sql.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public abstract class Validator {

    private final String NULL_MASSAGE = " must not be null";
    private final String EMPTY_MASSAGE = " must not be empty";

    protected void validateText(String str) {

        checkNotNull(str, "Text" + NULL_MASSAGE);
        checkArgument(!isBlank(str), "Text" + EMPTY_MASSAGE);
    }
    protected void validateText(String str, String hndl) {

        checkNotNull(str, hndl + NULL_MASSAGE);
        checkArgument(!isBlank(str), hndl + EMPTY_MASSAGE);
    }
    protected void validateDecimal(long num) {
        checkNotNull(num, "Number" + NULL_MASSAGE);
    }
    protected void validateDecimal(int num) {
        checkNotNull(num, "Number" + NULL_MASSAGE);
    }
    protected void validateDecimal(long num, String hndl) {
        checkNotNull(num, hndl + NULL_MASSAGE);
    }
    protected void validateDecimal(int num, String hndl) {
        checkNotNull(num, hndl + NULL_MASSAGE);
    }

    protected void validateState(boolean state) {
        checkNotNull(state, "State" + NULL_MASSAGE);
    }

    protected void validateDate(Date date) {
        checkNotNull(date, "Date" + NULL_MASSAGE);
    }
    protected void validateState(boolean state, String hndl) {
        checkNotNull(state, hndl + NULL_MASSAGE);
    }

    protected void validateDate(Date date, String hndl) {
        checkNotNull(date, hndl + NULL_MASSAGE);
    }

}
