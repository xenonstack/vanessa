package com.xenonstack.vanessa.web

import com.twitter.finatra.Controller
import java.sql.Statement
import java.sql.ResultSet
import java.sql.SQLException

class User extends Controller {

  get("/user/:username/:password") 
 {
		request => val connection:DbConnection =new DbConnection()
		val conn=connection.conn()
	try {
		    val username=request.routeParams.getOrElse("username", "john doe");
		    val password=request.routeParams.getOrElse("password", "aaa");
		    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
		    val prep = conn.prepareStatement("INSERT INTO user (username, password) VALUES (?, ?) ")
		    prep.setString(1, username)
		    prep.setString(2, password)
		    prep.executeUpdate
		 
		render.plain("User registred successfully").toFuture
	 }
	catch
	{
		case e: SQLException=>render.plain("Username Already in use").toFuture
	}
	finally
	{
  		 conn.close
	}
		  

}
}

