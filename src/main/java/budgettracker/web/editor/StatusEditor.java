package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;

import org.h2.util.StringUtils;

import budgettracker.domain.datatype.Status;

public class StatusEditor  extends PropertyEditorSupport {
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value))
            return;

        setValue(Status.valueOf(value));
    }

    @Override
    public String getAsText() {
        if(getValue() == null)
            return "";

        return ((Status) getValue()).name();
    }
}

