import static org.junit.Assert.*;
import org.junit.Test;
import customTools.DbUser;
import model.Bhuser;

public class BhuserTests {

	@Test
	public void getUserByEmail() {
		Bhuser u = DbUser.getUserByEmail("user1@domain.com");
		//System.out.println(u.getBhuserid());
		//assertTrue(u.getUsername().equals("user 1"));
		assertTrue(u.getBhuserid()==5);
	}
	@Test 
	public void isValidUser(){
		boolean isValid = DbUser.isValidUser("user1@domain.com", "password");
		assertTrue(isValid==true);
	}
	
	@Test
	public void insertUserTest(){
		Bhuser u = new Bhuser();
		u.setUsername("Bart Simpson");
		u.setMotto("don't have a cow man");
		u.setUseremail("bart@fox.net");
		u.setUserpassword("blue123");
		int x = DbUser.insert(u);
		assertTrue(1==x);
	}
	@Test
	public void updateUserTest(){
		long uid = 5;
		Bhuser u = DbUser.getUser(uid);
		u.setUsername("User1");
		u.setMotto("this is the motto for user 1");
		u.setUseremail("user1@domain.com");
		u.setUserpassword("password");
		int nmbrUpdated = DbUser.update(u);
		assertTrue(nmbrUpdated==1);
	}

}
