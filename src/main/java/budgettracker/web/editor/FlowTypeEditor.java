package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;

import org.h2.util.StringUtils;

import budgettracker.domain.datatype.FlowType;

public class FlowTypeEditor extends PropertyEditorSupport {
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value))
            return;

        setValue(FlowType.valueOf(value));
    }

    @Override
    public String getAsText() {
        if(getValue() == null)
            return "";

        return ((FlowType) getValue()).name();
    }
}
