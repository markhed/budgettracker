package budgettracker.domain.datatype;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.NotSupportedException;

import budgettracker.common.domain.EnumUserType;

public class FlowTypeUserType extends EnumUserType<FlowType> {

	public FlowTypeUserType() {
		super(FlowType.class);
	}

	private static List<FlowType> list;
	
	public static List<FlowType> getList() {
		list = new ArrayList<FlowType>();
		
		list.add(FlowType.Single);
		list.add(FlowType.Periodic);
		
		return list;
	}
	
	public static FlowType enumOf(Character charCode) throws NotSupportedException {
		switch (charCode) {
			case 'S':
				return FlowType.Single;
			case 'P':
				return FlowType.Periodic;
			default:
				throw new NotSupportedException();
		}	
	}
	
	public static Character codeOf(FlowType enumValue) throws NotSupportedException {
		switch (enumValue) {
			case Single:
				return 'S';
			case Periodic:
				return 'P';
			default:
				throw new NotSupportedException();
		}
	}
}
