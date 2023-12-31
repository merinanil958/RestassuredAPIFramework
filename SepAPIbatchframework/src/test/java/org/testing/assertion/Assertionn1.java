package org.testing.assertion;

public class Assertionn1 {
	public static Boolean assertion(int actual,int expected)
	{
		if(actual==expected)
		{
			System.out.println("Assertion is getting passed");
			return true;
		}
		else
		{
			System.out.println("Assertion is getting Failed");
			return false;
		}
	}
	public static Boolean assertion(String actual,String expected)
	{
		if(actual.equals(expected))
		{
			System.out.println("Assertion is getting passed");
			return true;
		}
		else
		{
			System.out.println("Assertion is getting Failed");
			return false;
		}
	}

}
