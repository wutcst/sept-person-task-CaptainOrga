package cn.edu.whut.sept.zuul;

public class CommandWords
{
	//目前包括了go,quit,help,get四个头指令
    private static final String[] validCommands = {
            "go", "quit", "help","get"
    };
    //
    public CommandWords()
    {
        
    	// nothing to do at the moment...
    }
    //isCommand函数用于判断头指令是否符合上面规定的那几个
    //是就返回true，否则false
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
    //showAll函数用于展示所有的合法指令
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}

