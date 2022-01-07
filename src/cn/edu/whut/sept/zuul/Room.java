package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String,String>weapons;
 /**
  * 创建一个描述为description的房间
  * 房间里有用hash存储的出口，还有武器信息。
  * @param description构造room的时候必须输入其描述信息
  */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        weapons=new HashMap<>();
    }
    /**
     * 给某个节点设置可以走的方向以及那个方向上的另一个节点
     * @param direction是指某个房间的一个方向
     * @param neighbor是指在这个方向基础上通向的节点
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    /**
     * 给某个房间设置里面有一些什么样的武器
     * @param description武器的描述属性
     * @param quality武器的品质属性
     */
    public void setWeapons(String description,String quality) {
    	weapons.put(description, quality);
    }


    /**
     * 返回描述
     * @return对房间的描述
     */
    public String getShortDescription()
    {
        return description;
    }
    /**
     * 返回更长的对所处房间的描述
     * @return对房间的描述，只不过更长了
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    /**
     * 当玩家身处某个节点，显示所有可以走的方向
     * @return返回所有获取到的方向
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * 显示房间内的物品
     * @return 返回所有物品的信息
     */
    String getWeaponsString() {
    	String returnString="weapons:";
    	Set<String>keys=weapons.keySet();
    	for(String weapon:keys) {
    		returnString +=" "+weapon;
    	}
    		return returnString;
    }
/**
 * 获取所有可以走的方向
 * @param direction输入方向
 * @return exits所有获得的方向
 */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
/**
 * 获取所有的武器信息
 * @return 描述武器的字符串
 */
	public String getWeapon() {
		return getWeaponsString();
	}
}





