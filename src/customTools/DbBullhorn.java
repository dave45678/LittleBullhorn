package customTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Bhpost;

public class DbBullhorn {

	public static void insert(Bhpost bhPost) {
		
	}

	public static void update(Bhpost bhPost) {
		
	}

	public static List<Bhpost> AllPosts () throws SQLException, ClassNotFoundException{
		List<Bhpost> posts = new ArrayList<Bhpost>();
		String sql = "select postid,postdate,posttext,bhuserid from bhpost";
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		// Fetch each row from the result set
		while (rs.next()) {
		  long postid = rs.getInt("postid");
		  String postdate = rs.getString("postdate");
		  String posttext = rs.getString("posttext");
		  long userid = rs.getLong("bhuserid");

		  Bhpost p = new Bhpost();
		  p.setPostid(postid);
		  //p.setPostdate(new java.util.Date(postdate));
		  p.setPosttext(posttext);
		  p.setBhuserid(userid);
		  //add the post to the arraylist
		  posts.add(p);
		}
		return posts;
	}
	
	public static List<Bhpost> postsofUser(long userid)
	{
		List<Bhpost> userposts = new ArrayList<Bhpost>();
	
		return userposts;	
	}
	public static List<Bhpost> postsofUser(String useremail)
	{
		List<Bhpost> userposts = new ArrayList<Bhpost>();
		
		return userposts;	
	}
	
	public static List<Bhpost> searchPosts (String search)
	{
		List<Bhpost> searchposts = new ArrayList<Bhpost>();
		
		String qString = "select b from Bhpost b "
				+ "where b.posttext like :search";
		
	    return searchposts;
	}
	
}