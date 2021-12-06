package com.example.spottyv2.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

/**
 * WebStreamer is a Springboot class that allows for streaming of data from the server to the client side webapp.
 * This is used as an extra feature for the "Matrix mode" allowing the user to see what the server is doing
 * while generating a playlist.
 * (Server side rendering for the "Matrix Mode")
 */

@Controller
@ControllerAdvice
public class WebStreamerController {

    @RequestMapping(path = {"/dataStream", "/dataStream?id={id}"})
    public StreamingResponseBody dataStream(
            @PathVariable(required=false,name="id") String id,
            @RequestParam(required=false) Map<String,String> qparams
    ) {

        StreamingResponseBody stream = out -> {
            boolean running = true;

            PrintStream previousConsole = System.out;
            ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
            System.setOut(new PrintStream(newConsole));
            System.out.println("======>" + id + "<========");
            System.out.println("======>" + id + "<========");
            System.out.println("======>" + id + "<========");
            System.out.println("======>" + id + "<========");

            out.write(("<head>\n" +
                    "<style>\n" +
                    "body {\n" +
                            "  background-color: black;\n" +
                            "  background-image: radial-gradient(\n" +
                            "    rgba(0, 150, 0, 0.75), black 120%\n" +
                            "  );\n" +
                            "  height: 100vh;\n" +
                            "  margin: 0;\n" +
                            "  overflow: hidden;\n" +
                            "  padding: 2rem;\n" +
                            "  color: white;\n" +
                            "  font: 1.3rem Inconsolata, monospace;\n" +
                            "  text-shadow: 0 0 5px #C8C8C8;\n" +
                            "  &::after {\n" +
                            "    content: \"\";\n" +
                            "    position: absolute;\n" +
                            "    top: 0;\n" +
                            "    left: 0;\n" +
                            "    width: 100vw;\n" +
                            "    height: 100vh;\n" +
                            "    background: repeating-linear-gradient(\n" +
                            "      0deg,\n" +
                            "      rgba(black, 0.15),\n" +
                            "      rgba(black, 0.15) 1px,\n" +
                            "      transparent 1px,\n" +
                            "      transparent 2px\n" +
                            "    );\n" +
                            "    pointer-events: none;\n" +
                            "  }\n" +
                            "}\n" +
                            "::selection {\n" +
                            "  background: #0080FF;\n" +
                            "  text-shadow: none;\n" +
                            "}\n" +
                            "pre {\n" +
                            "  margin: 0;\n" +
                            "}"+
                    ".container {\n" +
                            "  height: 100px;\n" +
                            "  overflow: auto;\n" +
                            "  display: flex;\n" +
                            "  flex-direction: column-reverse;\n" +
                            "}"+
                    "</style>\n" +
                    "</head>").getBytes());

            out.write(("<h1>Generating Playlist</h1>").getBytes());
            out.write(("<div class=\"container\" style=\"width:800px;height:600px;line-height:3em;overflow:auto;padding:5px;\">").getBytes());

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
                if (newConsole.toString().equals("Closing...")){
                    running = false;
                    out.write((newConsole.toString()).getBytes());
                    System.setOut(previousConsole);

                }
            }
            out.write(("</div>").getBytes());
            out.write((String.format("<form action=\"http://localhost:8080/home?id=%s\">\n", id) +
                    "    <input type=\"button\" value=\"Home\" onclick=\"history.go(-2)\"/>\n" +
                    "</form>").getBytes());
            out.close();
        };
        //Checking thread closing.

        System.out.println("Thread closed");

        return stream;

    }
}
