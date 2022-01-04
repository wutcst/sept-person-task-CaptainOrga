package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
	//预想是有east，south，west，north四个
	//字符串来输入文字，描述节点的名称
    private String description;
    //用哈希表存放房间可以走的方向
    private HashMap<String, Room> exits;
    private HashMap<String, Room> NPCs;
    //一个房间的信息包括它的描述以及
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }
    //setExit函数：给某个节点设置可以走的方向以及那个方向上的另一个节点
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    //返回描述
    public String getShortDescription()
    {
        return description;
    }
    //
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    //当玩家身处某个节点，显示所有可以走的方向
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    //显示该房间所有存在的NPC
    private String getNPCString() {
    	String returnString = "Some folks here:";
    	Set<String> keys=exits.keySet();
    	for(String NPC:keys) {
    		returnString +=" "+NPC;
    	}
    	return returnString;
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}





