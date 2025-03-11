package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.TemplateGenerator;

import java.io.IOException;

public class ConsoleMode {
    public static void main(String[] args) throws IOException {
        Messenger messenger = new Messenger(new TemplateGenerator());
        messenger.runConsoleMode();
    }
}
