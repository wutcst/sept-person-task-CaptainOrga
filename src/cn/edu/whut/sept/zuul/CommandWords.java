package cn.edu.whut.sept.zuul;
/**
 * 这是一个用于设置，判断用户的指令是否是预设的合法指令的类
 * @author 王
 *
 */
public class CommandWords
{
	/**
	 * 目前包括了go,quit,help,get，back五个头指令
	 */
    private static final String[] validCommands = {
            "go", "quit", "help","get","look","back"
    };
    /**
     * 
     */
    public CommandWords()
    {
    	// nothing to do at the moment...
    }
    /**
     * isCommand函数用于判断头指令是否符合上面规定的那几个
     * @param aString输入要判断的指令
     * @return 是合法指令就返回true，否则false
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
    /**
     * showAll函数用于展示所有的合法指令
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}

