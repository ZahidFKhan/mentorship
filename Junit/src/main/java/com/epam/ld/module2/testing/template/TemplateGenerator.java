package com.epam.ld.module2.testing.template;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Template.
 */
public class TemplateGenerator {
    Pattern pattern = Pattern.compile("#\\{([^}]+)\\}");

    public String generate(String template, Map<String, String> values) {
        Matcher matcher = pattern.matcher(template);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String variable = matcher.group(1);
            if (!values.containsKey(variable)) {
                throw new IllegalArgumentException("Missing value for variable: " + variable);
            }
            matcher.appendReplacement(result, values.get(variable));
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
