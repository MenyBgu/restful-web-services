package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    //GET
    //URI - /hello-world
    //method - "Hello World"

    //Option 2 : @GetMapping(path="/hello-world")
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    //hello-world-bean
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    //hello-world/path-variable/in28minutes
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        //  (@RequestHeader(name="Accept-Language",required=false) Locale locale){
        return messageSource
                .getMessage("good.morning.message", null, "Default Message"
                        //locale);
                        , LocaleContextHolder.getLocale());
    }
}
