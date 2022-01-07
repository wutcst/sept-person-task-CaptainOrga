package cn.edu.whut.sept.zuul;

import java.util.Scanner;
/**
 * 此类属于语法解释器
 * 此类尝试把用户输入的一整串字符解释为分开的两个单词组成的命令
 * 同时进行分析是否是合法命令之一，如果不是则标记为未知命令
 * 它返回Command类型
 * @author 王
 *
 */
public class Parser
{
    private CommandWords commands;
    private Scanner reader;
/**
 * 创建解析器读取用户输入
 */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
/**
 * 将用户输入的字符串解释为两个单词组成的命令
 * 分别扫描是否存在头指令和尾指令，如果有就分别返回两个单词
 * @return
 */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
        //在>后面输入指令
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    /**
     * 展示所有的指令
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
