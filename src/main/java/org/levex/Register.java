package org.levex;
import java.lang.*;

public class Register {
	
	private static int lastId = 999;

	private int value = 0;
	private String name = "";
	
	public Register() 
	{
		this.name = "r" + lastId;
		this.value = 0;
	}

	public Register(String name, int value)
	{
		this.value = value;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int v)
	{
		this.value = v;
	}
}
