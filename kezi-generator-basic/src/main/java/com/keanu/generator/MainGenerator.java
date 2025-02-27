package com.keanu.generator;

import com.keanu.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 19:40
 */
public class MainGenerator {

    /**
     * 动态生成文件
     *
     * @param mainTemplateConfig    配置参数
     * @throws TemplateException    模板异常
     * @throws IOException          IO 异常
     */
    public static void doGenerate(MainTemplateConfig mainTemplateConfig) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        String dynamicInputPath = projectPath + File.separator + "kezi-generator-basic" + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "kezi-generator-basic" + File.separator + "MainTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
