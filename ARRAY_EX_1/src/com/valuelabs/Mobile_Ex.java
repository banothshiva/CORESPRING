package com.valuelabs;

public class Mobile_Ex 
{

	public static void main(String[] args)
	{
		String[] mobileNames = {"oppo","samsung","nokia","one+", "redmi","realmi","iphone"};
		
		//GET THE FIRST MOBILE 
		System.out.println(mobileNames[0]);
		System.out.println("--------------------");
		//GET THE 3 -6 MOBILES LIST 
		for (int i = 2; i <=6; i++)
		{
			System.out.println(mobileNames[i]);
			
		}
		System.out.println("--------------------");
		// GET THE ALL THE MOBILE LIST 
		for (String mobiles : mobileNames) 
		{
			System.out.println(mobiles);
		}
		System.out.println("--------------------");
		System.out.println();
	}

}
