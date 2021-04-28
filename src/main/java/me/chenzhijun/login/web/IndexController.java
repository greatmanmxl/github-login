package me.chenzhijun.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chen
 * @version V1.0
 * @date 2017/9/29
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @GetMapping("/idx")
    public String index(Model model) {

        model.addAttribute("user", "userName");
        model.addAttribute("host", "http://127.0.0.1");
        return "index";

    }

    @GetMapping("/idx2")
    public ModelAndView index2() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", "user");
        modelAndView.addObject("host", "http://127.0.0.1");
        modelAndView.setViewName("index");
        return modelAndView;

    }


}
