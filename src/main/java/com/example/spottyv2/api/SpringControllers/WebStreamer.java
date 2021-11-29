package com.example.spottyv2.api.SpringControllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Controller
@ControllerAdvice
public class WebStreamer {

    @RequestMapping(value = "/dataStream")
    public ResponseEntity<StreamingResponseBody> dataStream() {

        StreamingResponseBody stream = out -> {
            boolean running = true;

            PrintStream previousConsole = System.out;
            ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
            System.setOut(new PrintStream(newConsole));

            out.write(("<h1>Generating Playlist</h1>").getBytes());

            while (running) {
                //System.out.println("test" + i);
                out.write((newConsole.toString()).getBytes());
                out.flush();
                newConsole = new ByteArrayOutputStream();
                System.setOut(new PrintStream(newConsole));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    break;
                }
                if (newConsole.toString().equals("Playlist generated.")){
                    running = false;
                    System.setOut(previousConsole);
                }
            }

            out.write(("<form action=\"http://localhost:8080/result\">\n" +
                    "    <input type=\"submit\" value=\"Get your playlist\" />\n" +
                    "</form>").getBytes());
        };

        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(stream);

    }
}
