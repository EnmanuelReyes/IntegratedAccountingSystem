package me.enmanuel.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 4:31 PM
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "redirect:/accountingentries";
    }
}