package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Weapon1 {
		//字符串来输入文字，描述节点的名称
	    private String description;
	    //private int Damage;
	    //private int Weight;
	    private String Quality;
	    //一把武器的信息包括它的描述以及威力,重量,品质
	    public Weapon1(String description,String quality)
	    {
	        this.description = description;
	        this.Quality=quality;
	        /*if(description=="AKM") {
	        	this.Weight=3;
	        	switch(quality) {
	        		case("GOOD"):this.Damage=35;
	        		case("NORMAL"):this.Damage=30;
	        		case("BAD"):this.Damage=24;
	        }}
	        else if(description=="MK17") {
	        	this.Weight=5;
	        	switch(quality) {
	        		case("GOOD"):this.Damage=75;
	        		case("NORMAL"):this.Damage=65;
	        		case("BAD"):this.Damage=50;}
	        }
	        else {//this.Weight=4;
	        	switch(quality) {
	        		case("GOOD"):this.Damage=20;
	        		case("NORMAL"):this.Damage=17;
	        		case("BAD"):this.Damage=14;}}*/
	    }
	    //返回描述
	    public String getShortDescription()
	    {
	        return description;
	    }
	    //
	    /*public String getAttackDescription()
	    {	
	    	String i=String.valueOf(Damage);
	        return "You fire to" + description + " and cause damage of" + i+".";
	    }*/
	    //当玩家身处某个节点，显示所有可以攻击的敌人
	    /*private String getTargetString()
	    {
	        String returnString = "Enemies:";
	        Set<String> keys = exits.keySet();
	        for(String exit : keys) {
	            returnString += " " + exit;
	        }
	        return returnString;
	    }*/
/*
	    public Room getExit(String direction)
	    {
	        return exits.get(direction);
	    }*/
	


}
