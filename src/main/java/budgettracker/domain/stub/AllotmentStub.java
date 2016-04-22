package budgettracker.domain.stub;

import java.util.ArrayList;
import java.util.Date;

import budgettracker.domain.AllotmentEntity;

public class AllotmentStub extends BaseStub<AllotmentEntity>{
	
	public AllotmentStub() {
		stubs = new ArrayList<AllotmentEntity>();
		AllotmentEntity allotment;
		
		allotment = new AllotmentEntity();
		allotment.setId(new Long(10001));
		allotment.setCurrentAmount(new Double(10002));
		allotment.setTargetAmount(new Double(10003));
		allotment.setTargetDate(new Date());
		allotment.setComment("allotment1 comment");
		allotment.setTitle("allotment1 title");
		stubs.add(allotment);
		
		allotment = new AllotmentEntity();
		allotment.setId(new Long(20001));
		allotment.setCurrentAmount(new Double(20002));
		allotment.setTargetAmount(new Double(20003));
		allotment.setTargetDate(new Date());
		allotment.setComment("allotment2 comment");
		allotment.setTitle("allotment2 title");
		stubs.add(allotment);
	}
}
