package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.InflowEntity;
import budgettracker.domain.OutflowEntity;

public class ViewCycleForm {
	private List<InflowEntity> inflowList;
	private List<OutflowEntity> outflowList;
	
	public List<InflowEntity> getInflowList() {
		return inflowList;
	}
	
	public void setInflowList(List<InflowEntity> inflowList) {
		this.inflowList = inflowList;
	}
	
	public List<OutflowEntity> getOutflowList() {
		return outflowList;
	}
	
	public void setOutflowList(List<OutflowEntity> outflowList) {
		this.outflowList = outflowList;
	}
	
	
}
