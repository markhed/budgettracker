package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;

import org.h2.util.StringUtils;

import budgettracker.domain.datatype.BudgetType;

public class BudgetTypeEditor extends PropertyEditorSupport {
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value))
            return;

        setValue(BudgetType.valueOf(value));
    }

    @Override
    public String getAsText() {
        if(getValue() == null)
            return "";

        return ((BudgetType) getValue()).name();
    }
}
