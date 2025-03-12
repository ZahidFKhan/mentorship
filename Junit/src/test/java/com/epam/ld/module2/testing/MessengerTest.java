package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.TemplateGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

class MessengerTest {


    @Test
    void whenRunInTheFileModeShouldPrintTheMessageFromTheFile(@TempDir Path tempDir) throws IOException {
        final var object = new Messenger(new TemplateGenerator());
        Messenger messenger = Mockito.spy(object);
        Mockito.doReturn("Hello #{username}").when(messenger).getFileTemplateInput(ArgumentMatchers.anyString());
        final var map = Map.of("username", "John");
        Mockito.doReturn(map).when(messenger).getValues(ArgumentMatchers.anyString());
        String result = messenger.runFileMode("test.txt");

        Assertions.assertEquals(result, "Hello John");
    }

}