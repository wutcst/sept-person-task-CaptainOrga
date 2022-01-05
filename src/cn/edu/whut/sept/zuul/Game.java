/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.Random;

public class Game
{
    private Parser parser;
    private Room currentRoom;

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("tp1", office);
        lab.setExit("tp2", outside);
        lab.setExit("tp3", pub);
        lab.setExit("tp4", theater);
        lab.setExit("tp5", lab);
        

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
        //create the weapons
        outside.setWeapons("AKM(3.5kg)", "NORMAL");
        lab.setWeapons("MK47(4.5kg)", "GOOD");
        office.setWeapons("mental rifle(5.5kg)", "BAD");
        //create NPC
        lab.setNPCS("TPlink(TP+Destination)", "TPman");
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        if (commandWord.equals("go")) {
            goRoom(command);
        }
        if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        if(commandWord.equals("look")) {
        	lookforgoods(command);
        }
        if(commandWord.equals("TP")) {
        	TPlink(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * 执行help指令，在终端打印游戏帮助信息.
     * 此处会输出游戏中用户可以输入的命令列表
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    /**
     * 执行查看物品指令。如果该房间存在物品，则会进行显示
     * 否则打印“no goods here.”
     */
    private void lookforgoods(Command command) {
    	Room room=currentRoom;
    	String weaponstring=room.getWeaponsString();
    	String NPCSString=room.getNPCS();
    	System.out.println(weaponstring);
    	System.out.println(NPCSString);
    	System.out.println(currentRoom.getLongDescription());
    }
    /**
     * 执行tp指令，向指定房间移动
     */
    private void TPlink(Command command) {
    	if(currentRoom.getShortDescription()!="in a computing lab") {
    		System.out.println("You can't tp here.No tplink.");
    		return;
    	}
    	if(!command.hasSecondWord()) {
            System.out.println("TPlink:TP where?");
            return;
        }
    	//System.out.println("TPlink:HI,where you want to go?");
    	String destination=command.getSecondWord();
    	if(destination=="in the computing admin office"||destination=="in a computing lab"||destination=="in a lecture theater"||destination=="outside the main entrance of the university"||destination=="in the campus pub") {
    		System.out.println("TPlink:NO such place!");
    		return;
    	}
    	else {
    	System.out.println("TPlink:Well,"+destination);
    		Room nextroom;
    		switch(destination) {
    		case ("office"):destination="in the computing admin office";break;
    		case ("outside"):destination="outside the main entrance of the university";break;
    		case ("pub"):destination="in the campus pub";break;
    		case ("theater"):destination="in a lecture theater";break;
    		case ("lab"):destination="in a computing lab";break;
    		}
    		if(destination=="in the computing admin office") {
    			nextroom=currentRoom.getExit("tp1");
    			currentRoom=nextroom;
    			System.out.println(currentRoom.getLongDescription());
    		}
    		if(destination=="outside the main entrance of the university") {
    			nextroom=currentRoom.getExit("tp2");
    			currentRoom=nextroom;
    			System.out.println(currentRoom.getLongDescription());
    		}
    		if(destination=="in the campus pub") {
    			nextroom=currentRoom.getExit("tp3");
    			currentRoom=nextroom;
    			System.out.println(currentRoom.getLongDescription());
    		}
    		if(destination=="in a lecture theater") {
    			nextroom=currentRoom.getExit("tp4");
    			currentRoom=nextroom;
    			System.out.println(currentRoom.getLongDescription());
    		}
    		if(destination=="in a computing lab") {
    			nextroom=currentRoom.getExit("tp5");
    			currentRoom=nextroom;
    			//System.out.println(5);
    			System.out.println(currentRoom.getLongDescription());
    		}
    	}
    	System.out.println("TPlink:You've arrived.");
    }
    /**
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
        }
    }

    /**
     * 执行Quit指令，用户退出游戏。如果用户在命令中输入了其他参数，则进一步询问用户是否真的退出.
     * @return 如果游戏需要退出则返回true，否则返回false.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}