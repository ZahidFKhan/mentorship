package com.junit;

import com.epam.ld.module2.testing.template.TemplateGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemplateGeneratorTest {
    private final TemplateGenerator generator = new TemplateGenerator();
    
    @BeforeAll
    static void setUp() {
        System.setProperty("disableTests", "true");
    }

    @Test
    public void testSimpleReplacement() {
        Map<String, String> values = new HashMap<>();
        values.put("name", "John");
        String result = generator.generate("Hello, #{name}!", values);
        Assertions.assertEquals("Hello, John!", result);
    }

    @Test
    public void testMultipleReplacements() {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Alice");
        values.put("city", "Wonderland");
        String result = generator.generate("Hello, #{name}! Welcome to #{city}.", values);
        assertEquals("Hello, Alice! Welcome to Wonderland.", result);
    }

    @Test
    public void testMissingValueThrowsException() {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Bob");
        assertThrows(IllegalArgumentException.class, () -> generator.generate("Hello, #{name}! You are from #{city}.", values));
    }

    @Test
    public void testExtraValuesAreIgnored() {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Charlie");
        values.put("extra", "value");
        String result = generator.generate("Hello, #{name}!", values);
        assertEquals("Hello, Charlie!", result);
    }

    @Test
    public void testVariableValueContainingPlaceholder() {
        Map<String, String> values = new HashMap<>();
        values.put("value", "#{tag}");
        String result = generator.generate("Some text: #{value}", values);
        assertEquals("Some text: #{tag}", result);
    }

    @Test
    @DisabledIfSystemProperty(named = "disableTests", matches = "false")
    public void testLatin1Characters() {
        Map<String, String> values = new HashMap<>();
        values.put("subject", "café");
        String result = generator.generate("Subject: #{subject}", values);
        assertEquals("Subject: café", result);
    }
}
