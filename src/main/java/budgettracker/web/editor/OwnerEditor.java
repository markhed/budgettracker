package budgettracker.web.editor;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.h2.util.StringUtils;

import budgettracker.domain.OwnerEntity;

public class OwnerEditor extends PropertyEditorSupport {
	
	List<OwnerEntity> owners;
	
	public OwnerEditor(List<OwnerEntity> owners) {
		this.owners = owners;
	}
	
	@Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(StringUtils.isNullOrEmpty(value))
            return;
        
        Long longValue = Long.valueOf(value);
        for (OwnerEntity owner : owners) {
        	if (owner.getId().equals(longValue)) {
        		setValue(owner);
        		break;
        	}
        }
    }
}
