package com.keanu.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.keanu.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 22:04
 */
@CommandLine.Command(name = "config", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段类型：" + field.getType());
            System.out.println("字段名称：" + field.getName());
        }
    }
}
