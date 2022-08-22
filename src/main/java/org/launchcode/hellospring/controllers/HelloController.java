package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }


    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles a request of the form /hello/?name=LaunchCode
    //lives at /hello
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return createMessage(name,language);
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + //submit a request to "hello"
                "<input type = 'text' name = 'name'>" +
                "<select name = 'language'>" +
                "<option value = 'English'> English </option>" +
                "<option value = 'Spanish'> Spanish </option>" +
                "<option value = 'German'> German </option>" +
                "<option value = 'French'> French </option>" +
                "<option value = 'Chinese'> Chinese </option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        if (language.equals("German")) {
            return "Halo, " + name + "!";
        } else if (language.equals("Spanish")){
            return "Hola, "+ name + "!";
        }else if (language.equals("French")){
            return "Bonjour, " + name + "!";
        } else if (language.equals("Chinese")){
            return "Ni hao, " + name + "!";
        }else {
            return "Hello, " + name + "!";
        }
    }

}
