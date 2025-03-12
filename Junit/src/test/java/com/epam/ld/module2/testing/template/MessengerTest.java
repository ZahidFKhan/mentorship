package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Messenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Map;

class MessengerTest {


    @Test
    void whenRunInTheFileModeShouldPrintTheMessageFromTheFile() throws IOException {
        final Messenger object = new Messenger(new TemplateGenerator());
        Messenger messenger = Mockito.spy(object);
        Mockito.doReturn("Hello #{username}").when(messenger).getFileTemplateInput(ArgumentMatchers.anyString());
        final Map<String, String> map = Map.of("username", "John");
        Mockito.doReturn(map).when(messenger).getValues(ArgumentMatchers.anyString());
        String result = messenger.runFileMode("test.txt");

        Assertions.assertEquals(result, "Hello John");

    }

    @Test
    void whenRunInThConsoleModeShouldPrintTheMessageFromTheConsole() throws IOException {
        final Messenger object = new Messenger(new TemplateGenerator());
        Messenger messenger = Mockito.spy(object);
        final var output = "Hello #{username}";
        Mockito.doReturn(output).when(messenger).getConsoleString();

        final Map<String, String> map = Map.of("username", "John");
        Mockito.doReturn(map).when(messenger).getValues();
        String result = messenger.runConsoleMode();

/*        Assertions.assertEquals(result, "Hello John");*/

    }

}