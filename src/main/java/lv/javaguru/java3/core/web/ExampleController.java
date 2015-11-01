package lv.javaguru.java3.core.web;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        map.put("greeting", "greeting");

        return "index";
    }

    @RequestMapping("/login")
    public String home() {
        return "login";
    }

    @RequestMapping("/a")
    public String main() {
        return "login";
    }

    @RequestMapping("/*")
    public String main2() {
        return "login";
    }

}