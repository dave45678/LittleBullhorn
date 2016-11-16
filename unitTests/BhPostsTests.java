import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import customTools.DbBullhorn;
import model.Bhpost;

public class BhPostsTests {

	@Test
	public void test() {
		try {
			ArrayList<Bhpost> posts = (ArrayList<Bhpost>) DbBullhorn.AllPosts();
			//System.out.println(posts.get(0).getPosttext());
			assertTrue(posts.get(0).getPosttext().equals("ddd"));
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
