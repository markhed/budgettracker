package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;

import org.h2.util.StringUtils;

public class DoubleEditor extends PropertyEditorSupport {
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value)) {
        	setValue(null);
        } else {
        	setValue(Double.valueOf((value)));
        }
    }

    @Override
    public String getAsText() {
        if(getValue() == null || (Double) getValue() == 0)
            return "";

        return ((Double) getValue()).toString();
    }
}
