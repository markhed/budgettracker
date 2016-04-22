package budgettracker.domain;

import budgettracker.domain.stub.PartyStub;
import junit.framework.TestCase;

public class PartyEntityTest extends TestCase {

    private PartyEntity partyEntity;
    
    @Override
    protected void setUp() throws Exception {
    	partyEntity = new PartyEntity();
    }
  
    public void testSetAndGetComment() {      
        //test case - comment is null
        assertNull(partyEntity.getComment());
        
        //test case - comment is set
        partyEntity.setComment(PartyStub.COMMENT);
        assertEquals(PartyStub.COMMENT, partyEntity.getComment());
    }
    
    public void testSetAndGetTitle() {
    	//test case - title is null
        assertNull(partyEntity.getTitle());
        
        //test case - title is set
        partyEntity.setTitle(PartyStub.TITLE);
        assertEquals(PartyStub.TITLE, partyEntity.getTitle());
    }
    
    public void testSetAndGetFirstName() {
        //test case - firstName is null
        assertNull(partyEntity.getFirstName());
        
        //test case - firstName is set
        partyEntity.setFirstName(PartyStub.FIRST_NAME);
        assertEquals(PartyStub.FIRST_NAME, partyEntity.getFirstName());
    }
    
    public void testSetAndGetLastName() {
        //test case - lastName is null
        assertNull(partyEntity.getLastName());
        
        //test case - lastName is set
        partyEntity.setLastName(PartyStub.LAST_NAME);
        assertEquals(PartyStub.LAST_NAME, partyEntity.getLastName());
    }

}