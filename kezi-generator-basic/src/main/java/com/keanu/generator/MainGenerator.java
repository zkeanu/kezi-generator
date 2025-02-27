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
    public static void main(String[] args) throws TemplateException, IOException {
        // 1. 静态文件生成
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "kezi-generator-demo-projects" + File.separator + "acm-template";
        System.out.println(inputPath);
        String outputPath = projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 2. 动态文件生成
        String dynamicInputPath = projectPath + File.separator + "kezi-generator-basic" + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "kezi-generator-basic" + File.separator + "MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("keanu");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
