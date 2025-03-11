package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.template.TemplateGenerator;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Messenger.
 */
public class Messenger {
    private final TemplateGenerator templateGenerator;
    private MailServer mailServer;

    public Messenger(TemplateGenerator templateGenerator) {
        this.templateGenerator = templateGenerator;
    }

    private static String getConsoleString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter template: ");
        return reader.readLine();
    }

    String getFileTemplateInput(String inputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {

            return reader.readLine();
        }
    }

     Map<String, String> getValues(String inputFilePath) throws IOException {
        Map<String, String> values = new HashMap<>();

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    values.put(parts[0], parts[1]);
                }
            }
        }
        return values;
    }

    private static Map<String, String> getValues() throws IOException {
        Map<String, String> values = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter variable (name=value, or 'done'): ");
            String input = reader.readLine();
            if ("done".equals(input)) {
                break;
            }
            String[] parts = input.split("=");
            if (parts.length == 2) {
                values.put(parts[0], parts[1]);
            } else {
                System.out.println("Invalid input format. Use name=value.");
            }
        }
        return values;
    }

    public String runConsoleMode() throws IOException {
        String template = getConsoleString();

        final var values = getValues();

        String result = templateGenerator.generate(template, values);
        System.out.println("Result: " + result);
        return result;
    }

    public String runFileMode(String inputFilePath) throws IOException {
        final String template = getFileTemplateInput(inputFilePath);
        final var values = getValues(inputFilePath);

        final String result = templateGenerator.generate(template, values);
        System.out.println(result);
        return result;
    }
}
