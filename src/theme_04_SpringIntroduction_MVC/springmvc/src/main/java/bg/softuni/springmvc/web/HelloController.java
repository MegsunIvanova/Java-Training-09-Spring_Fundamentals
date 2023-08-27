package bg.softuni.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/hello")
public class HelloController {

        @GetMapping("/hello/{id}/test")
    public String hello(Model model,
                          @PathVariable("id") Integer id) {
        //http://localhost:8080/hello/44/test
        model.addAttribute("num", id);

        return "hello";//the same name as html file
    }

//    @GetMapping("/hello")
//    public String hello(Model model,
//                          @RequestParam("num") Integer num) {
//        //http://localhost:8080/user?num=42
//        model.addAttribute("num", num);
//
//        return "hello";//the same name as html file
//    }

//    @GetMapping
//    public String hello(ModelMap model) {
//
//        model.put("num", 4);
//
//        return "hello";
//    }

//    @GetMapping("/hello")
//    public ModelAndView newUser(ModelAndView modelAndView) {
//
//        modelAndView.addObject("num", 10);
//        modelAndView.setViewName("hello");
//
//        return modelAndView;
//    }
}
