package budgettracker.domain.stub;

import java.util.ArrayList;

import budgettracker.domain.PartyEntity;

public class PartyStub extends BaseStub<PartyEntity> {
	
    public final static String COMMENT = "comment";
    public final static String TITLE = "title";
    public final static String FIRST_NAME = "first name";
    public final static String LAST_NAME = "last name";
    
	public PartyStub() {
		stubs = new ArrayList<PartyEntity>();
		PartyEntity party;
		
		party = new PartyEntity();
		//party.setId(new Long(10001));
		party.setFirstName(COMMENT+1);
		party.setLastName(LAST_NAME+1);
		party.setTitle(TITLE+1);
		party.setComment(COMMENT+1);
		stubs.add(party);
		
		party = new PartyEntity();
		//party.setId(new Long(20001));
		party.setFirstName(COMMENT+2);
		party.setLastName(LAST_NAME+2);
		party.setTitle(TITLE+2);
		party.setComment(COMMENT+2);
		stubs.add(party);
	}
}
