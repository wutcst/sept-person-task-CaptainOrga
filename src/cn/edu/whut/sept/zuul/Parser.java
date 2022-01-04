package cn.edu.whut.sept.zuul;

import java.util.Scanner;
//此文件属于语法分析器
public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
        //在>后面输入指令
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        //分别扫描是否存在头指令和尾指令，如果有就分别赋值
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        //如果头指令符合条件则返回两个单词
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
