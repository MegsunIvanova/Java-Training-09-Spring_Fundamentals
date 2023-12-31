package org.softuni.util;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class CLGreeter implements CommandLineRunner {

    private final Gson gson;

    public CLGreeter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        String json = gson.toJson(new Point(1, 4));
        System.out.println("My point: " + json);
    }
}
