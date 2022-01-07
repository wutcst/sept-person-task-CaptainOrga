package cn.edu.whut.sept.zuul;
/**
 * 这个自定义的Command类是用于对用户输入信息进行处理的类
 */
public class Command
{
    private String commandWord;
    private String secondWord;	
    /**
     * 
     * @param firstWord用于获取用户输入的第一个单词
     * @param secondWord用于获取用户输入的第二个单词
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }
/**
 * 获取头指令
 * @return用户输入的第一个单词
 */
    public String getCommandWord()
    {
        return commandWord;
    }
/**
 * 获取第二个指令
 * @return用户输入的第二个单词
 */
    public String getSecondWord()
    {
        return secondWord;
    }
    /**
     * 判断头指令是否未知
     * @return不符合库中的，返回1，否则返回0
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }
    /**
     * 判断第二指令有没有
     * @return没有，则返回1，如果有，返回0
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
