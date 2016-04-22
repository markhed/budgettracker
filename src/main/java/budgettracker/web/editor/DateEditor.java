package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;

import java.util.Date;
import org.h2.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value)) {
        	setValue(new Date());
        } else {
        	setValue(new Date()); //temp
        }
    }

    @Override
    public String getAsText() {
        if(getValue() == null)
            return "";

        return ((Date) getValue()).toString();
    }
}