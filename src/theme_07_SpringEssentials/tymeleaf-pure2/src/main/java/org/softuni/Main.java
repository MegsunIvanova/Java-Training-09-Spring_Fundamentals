package org.softuni;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class Main {
    public static void main(String[] args) {
       ITemplateEngine templateEngine = createThymeleafTemplateEngine();

        Context context = new Context();

        context.setVariable("name", "SoftUni");

        String html = templateEngine.process("test.html", context);

        System.out.println(html);

    }

    private static ITemplateEngine createThymeleafTemplateEngine () {
        TemplateEngine engine = new TemplateEngine();

        engine.setTemplateResolver(new ClassLoaderTemplateResolver());

        return engine;
    }
}