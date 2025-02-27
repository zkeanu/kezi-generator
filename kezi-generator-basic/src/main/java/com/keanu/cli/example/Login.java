package com.keanu.cli.example;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import picocli.CommandLine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 20:59
 */
public class Login implements Callable<Integer> {

    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, description = "Passphrase", arity = "0..1", interactive = true, prompt = "请输入密码")
    String password;

    @CommandLine.Option(names = {"-cp", "--checkPassword"}, description = "Check Password", arity = "0..1", interactive = true, prompt = "请再次输入密码")
    String checkPassword;

    @Override
    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        List<String> argsList = new ArrayList<>();
        argsList.add("-u");
        argsList.add("keanu");
        argsList.add("-p");
        if (!CollUtil.contains(argsList, "-p")) {
            argsList.add("-p");
        }
        if (!CollUtil.contains(argsList, "-cp")) {
            argsList.add("-cp");
        }
        new CommandLine(new Login()).execute(ArrayUtil.toArray(argsList, String.class));
    }
}
