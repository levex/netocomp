package org.levex;
import java.lang.*;
import java.sql.*;
import javax.sql.*;

public class RegisterSet {
	private Register[] registers;
	private int regnum;
	public static Exception lastExce;
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;

	public RegisterSet(int regs) throws Exception
	{
		if(regs == 0) throw new Exception("Invalid register number");
		this.regnum = regs;
		registers = new Register[this.regnum];
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://127.13.36.130/jbosstest",
				"adminnltpXrr",
				"pBLdTLIB7BQR");
		stmt = con.createStatement();
		rs = stmt.executeQuery(
			"SELECT * FROM Netocomp");
		while(rs.next()) {
			for(int i = 0; i < regs; i++) {
				registers[i] = new Register("r"+i, rs.getInt("r"+i));	
			}
		}
		} catch (Exception e) {
			lastExce = e;
			throw new Exception(e);		
		}
	}

	public void setRegister(int i, int v) throws Exception {
		rs = stmt.executeQuery("UPDATE Netocomp SET r"+i+"="+v+";");
		registers[i].setValue(v);
	}
	
	public Register getRegister(int i) throws Exception
	{
		if(i > regnum) throw new Exception("Invalid register number");
		return registers[i];
	}
	
	public int size()
	{
		return regnum;
	}

}
