package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Weapon {
		//字符串来输入文字，描述节点的名称
	    private String description;
	    private int Damage;
	    //一把武器的信息包括它的描述以及威力
	    public Weapon(String description,int damage)
	    {
	        this.description = description;
	        this.Damage=damage;
	    }
	    //返回描述
	    public String getShortDescription()
	    {
	        return description;
	    }
	    //
	    public String getAttackDescription()
	    {	
	    	String i=String.valueOf(Damage);
	        return "You fire to" + description + " and cause damage of" + i+".";
	    }
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
