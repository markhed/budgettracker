package budgettracker.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import budgettracker.common.domain.BaseEntity;

public class BTListUtils {
	/**
	 * Removes items with no data from the list. If the list is null, a new (empty) list is returned.
	 * @param List<? extends BaseEntity>
	 */
	public static List<? extends BaseEntity> filter(List<? extends BaseEntity> list) {
		if (list != null) {
			Iterator<? extends BaseEntity> iterator = list.iterator();
			while (iterator.hasNext()){
				if (!iterator.next().hasData()) {
					iterator.remove();
				}
			}

			return list;
		} else {
			return new ArrayList<BaseEntity>();
		}
	}
}
