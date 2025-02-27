package com.keanu.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.keanu.generator.DynamicGenerator;
import com.keanu.generator.MainGenerator;
import com.keanu.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import lombok.Getter;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 22:04
 */
@CommandLine.Command(name = "generate", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable {

    /**
     * 是否生成循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, description = "是否循环", arity = "0..1", interactive = true, echo = true)
    private boolean loop;

    /**
     * 作者注释
     */
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者名称", arity = "0..1", interactive = true, echo = true)
    private String author = "keanu";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o", "--outputText"}, description = "输出文本", arity = "0..1", interactive = true, echo = true)
    private String outputText = "sum = ";

    @Override
    public Object call() throws Exception {
        MainTemplateConfig mainTemplateConfig = BeanUtil.copyProperties(this, MainTemplateConfig.class);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
