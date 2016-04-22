package budgettracker.domain.datatype;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.NotSupportedException;

import budgettracker.common.domain.BaseEntity;
import budgettracker.common.domain.EnumUserType;
import budgettracker.domain.BudgetAccountEntity;
import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.InflowEntity;
import budgettracker.domain.OutflowEntity;

public class StatusUserType extends EnumUserType<Status> {
	
	public StatusUserType() { 
		super(Status.class); 
	} 

	private static List<Status> list;
	
	public static List<Status> getList(Class<? extends BaseEntity> clazz) {
		list = new ArrayList<Status>();
		
		if (clazz == BudgetCycleEntity.class) {
			list.add(Status.Incoming);
		}
		
		if (clazz == InflowEntity.class) {
			list.add(Status.Awaiting);
		}
		
		if (clazz == InflowEntity.class) {
			list.add(Status.Received);
		}
		
		if (clazz == OutflowEntity.class) {
			list.add(Status.Outstanding);
		}
		
		if (clazz == OutflowEntity.class) {
			list.add(Status.Incurred);
		}		
		
		if (clazz == BudgetAccountEntity.class || clazz == BudgetCycleEntity.class) {
			list.add(Status.Active);
		}
		
		if (clazz == BudgetAccountEntity.class) {
			list.add(Status.Inactive);
		}
		
		if (clazz == BudgetCycleEntity.class) {
			list.add(Status.Archived);
		}
		
		if (clazz == InflowEntity.class || clazz == OutflowEntity.class) {
			list.add(Status.Deferred);
		}
		
		if (clazz == InflowEntity.class || clazz == OutflowEntity.class) {
			list.add(Status.Cancelled);
		}
		
		return list;
	}
	
	public static Status enumOf(Character charCode) throws NotSupportedException {
		switch (charCode) {
			case 'N':
				return Status.Incoming;
			case 'W':
				return Status.Awaiting;
			case 'H':
				return Status.Archived;
			case 'O':
				return Status.Outstanding;
			case 'V':
				return Status.Inactive;
			case 'A':
				return Status.Active;
			case 'I':
				return Status.Incurred;
			case 'R':
				return Status.Received;
			case 'D':
				return Status.Deferred;
			case 'C':
				return Status.Cancelled;
			default:
				throw new NotSupportedException();
		}
	}
		
	public static Character codeOf(Status enumValue) throws NotSupportedException {
		switch (enumValue) {
			case Incoming:
				return 'N';
			case Awaiting:
				return 'W';
			case Archived:
				return 'H';
			case Outstanding:
				return 'O';
			case Inactive:
				return 'V';
			case Active:
				return 'A';
			case Incurred:
				return 'I';
			case Received:
				return 'R';
			case Deferred:
				return 'D';
			case Cancelled:
				return 'C';
			default:
				throw new NotSupportedException();
		}
	}
	
}