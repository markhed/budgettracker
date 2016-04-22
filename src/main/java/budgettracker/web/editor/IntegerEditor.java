package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;

import org.h2.util.StringUtils;

public class IntegerEditor extends PropertyEditorSupport {
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value)) {
        	setValue(null);
        } else {
        	setValue(Integer.valueOf((value)));
        }
    }

    @Override
    public String getAsText() {
        if(getValue() == null)
            return "";

        return ((Integer) getValue()).toString();
    }
}
