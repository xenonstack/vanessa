package com.xenonstack.vanessa.web

import java.sql.DriverManager
import java.sql.Connection
import java.sql.Statement
import java.sql.ResultSet

class DbConnection
{
	def conn():Connection  ={
            val dbc = "jdbc:mysql://localhost:3306/vanessa?user=root&password=mysql"
	    classOf [com.mysql.jdbc.Driver]
	    return DriverManager.getConnection(dbc)
	}
}