package com.keanu.cli;

import com.keanu.cli.command.ConfigCommand;
import com.keanu.cli.command.GenerateCommand;
import com.keanu.cli.command.ListCommand;
import picocli.CommandLine;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 22:05
 */
@CommandLine.Command(name = "keanu", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     *
     * @param args  参数
     * @return      执行状态码
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
