package budgettracker.domain.stub;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseStub<T> {
	
	ArrayList<T> stubs;
	
	public T getStub(int index) {
		if (index < stubs.size()) {
			return stubs.get(index);
		}
		else {
			return stubs.get(0);
		}
	}
	
	public List<T> getStubs() {
		return stubs;
	}
}
