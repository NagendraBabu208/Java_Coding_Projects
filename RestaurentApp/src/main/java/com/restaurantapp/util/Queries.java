package com.restaurantapp.util;

public class Queries {
	
	public static final String INSERTQUERY="Insert into restaurant values(?,?,?,?,?,?,?,?,?)";
	public static final String UPDATEQUERY="Update restaurant set cost_For_Two=? where restaurant_Id=?";
	public static final String SELECTQUERTBYRESTAURANTID="Select * from restaurant where restaurant_Id=?";
	public static final String SELECTQUERY="Select * from restaurant";
	public static final String DELETEQUERY="Delete from restaurant where restaurant_Id=?";
	public static final String SELECTBYCITY="Select * from restaurant where city=?";
	public static final String SELECTTYPELESSERTHENCOSTQUERY="select *  from restaurant where type=? AND cost_For_Two<?";
	public static final String SELECTBYCUISINELESSERTHANCOST="Select * from restaurant where cuisine=? AND cost_For_Two<?";
	public static final String SELECTBYCOST="Select * from restaurant where cost_For_Two<?";
	public static final String SELECTBYTYPEANDRATINGSQUERY="select * from restaurant where type=? AND ratings=?";
	public static final String SELECTBYTIME="select * from restaurant where ?"
			+ "                     between restaurant_opening_time AND restaurant_closing_time";


}
