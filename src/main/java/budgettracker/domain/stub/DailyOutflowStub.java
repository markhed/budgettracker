package budgettracker.domain.stub;

import java.util.ArrayList;

import budgettracker.domain.DailyOutflowEntity;

public class DailyOutflowStub extends BaseStub<DailyOutflowEntity>{
	
	public DailyOutflowStub() {
		
		stubs = new ArrayList<DailyOutflowEntity>();
		DailyOutflowEntity dailyOutflow;
		
		dailyOutflow = new DailyOutflowEntity();
		dailyOutflow.setId(new Long(10001));
		dailyOutflow.setComment("dailyOutflow1 comment");
		dailyOutflow.setTitle("dailyOutflow1 title");
		dailyOutflow.setTotalUnits(10002);
		dailyOutflow.setUnitAmount(new Double(10003));
		stubs.add(dailyOutflow);
		
		dailyOutflow = new DailyOutflowEntity();
		dailyOutflow.setId(new Long(20001));
		dailyOutflow.setComment("dailyOutflow2 comment");
		dailyOutflow.setTitle("dailyOutflow2 title");
		dailyOutflow.setTotalUnits(20002);
		dailyOutflow.setUnitAmount(new Double(20003));
		stubs.add(dailyOutflow);
	}
}
