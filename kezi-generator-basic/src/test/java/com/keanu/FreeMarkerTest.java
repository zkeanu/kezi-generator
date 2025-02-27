package com.keanu;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 18:25
 */
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/template"));
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2025);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "keanu.monster");
        menuItem1.put("label", "KEPI");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "keanu.com.cn");
        menuItem2.put("label", "KEOJ");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);

        Writer out = new FileWriter("myweb.html");

        template.process(dataModel, out);

        out.close();
    }
}
