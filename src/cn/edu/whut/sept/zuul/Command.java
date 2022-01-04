package cn.edu.whut.sept.zuul;

public class Command
{
    private String commandWord;
    private String secondWord;
//Command函数：令第一个单词作为头指令，第二个作为后指令		
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }
//如果判断头指令未知，即不符合库中的，返回1，否则返回0
    public boolean isUnknown()
    {
        return (commandWord == null);
    }
//判断第二指令没有，则返回1，如果有，返回0
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
