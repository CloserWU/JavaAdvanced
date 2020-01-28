package com.closer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * <p>TemplateEngine</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-22 09:48
 */
public class TemplateEngine {
    private static String templateEnginRegex(Map<String, String> map, String template) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            template = template.replaceAll("\\$\\{" + entry.getKey() + "}", entry.getValue());
        }
        return template;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "job");
        map.put("lang", "java");
        System.out.println(templateEnginRegex(map, "Hello, ${name}! You are learning ${lang}!"));
        search();
    }

    public static void search() {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

}

