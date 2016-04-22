package budgettracker.domain.datatype;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.NotSupportedException;

import budgettracker.common.domain.EnumUserType;

public class BudgetTypeUserType extends EnumUserType<BudgetType>  {
	public BudgetTypeUserType() {
		super(BudgetType.class);
	}

	private static List<BudgetType> list;

	public static List<BudgetType> getList() {
		list = new ArrayList<BudgetType>();
		
		list.add(BudgetType.Actual);
		list.add(BudgetType.Planned);
		
		return list;
	}

	public static BudgetType enumOf(Character charCode) throws NotSupportedException {
		switch (charCode) {
			case 'A':
				return BudgetType.Actual;
			case 'P':
				return BudgetType.Planned;
			default:
				throw new NotSupportedException();
		}	
	}
	
	public static Character codeOf(BudgetType enumValue) throws NotSupportedException {
		switch (enumValue) {
			case Actual:
				return 'A';
			case Planned:
				return 'P';
			default:
				throw new NotSupportedException();
		}
	}
}
