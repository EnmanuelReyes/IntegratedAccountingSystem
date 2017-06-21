package me.enmanuel.accounting.controller;

import me.enmanuel.accounting.entity.AccountType;
import me.enmanuel.accounting.repository.AccountTypeRepository;
import me.enmanuel.accounting.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 4:31 PM
 */
@Controller
public class AccountTypeController {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/accounttypes")
    public ModelAndView accountTypes(ModelAndView modelAndView) {
        attachAccountTypes(modelAndView.getModelMap());
        modelAndView.setViewName("accounttypes");
        return modelAndView;
    }


    @RequestMapping(value = "/accounttype/{accountTypeId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("accountTypeId")AccountType accountType) {
        modelAndView.setViewName("accounttype");
        modelAndView.addObject("accountType", accountType);
        attachStatuses(modelAndView.getModelMap());
        return modelAndView;
    }


    @PostMapping(value = "/accounttype")
    public ModelAndView save(ModelAndView modelAndView, AccountType accountType, RedirectAttributes redirectAttributes) {
        accountTypeRepository.save(accountType);
        redirectAttributes.addFlashAttribute("success", "El restaurante fue guardada correctamente");
        modelAndView.setViewName("redirect:/accounttypes");
        return modelAndView;
    }


    @RequestMapping(value = "/accounttype/create")
    public ModelAndView create(ModelAndView modelAndView) {

        modelAndView.setViewName("accounttype");
        modelAndView.addObject("accountType", new AccountType());
        attachStatuses(modelAndView.getModelMap());
        return modelAndView;
    }


    @RequestMapping(value = "/accounttype/delete/{accountTypeId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer accountTypeId,
                               RedirectAttributes redirectAttributes) {
        accountTypeRepository.delete(accountTypeId);
        redirectAttributes.addFlashAttribute("success", "El restaurante fue eliminado correctamente");
        modelAndView.setViewName("redirect:/accounttypes");
        return modelAndView;
    }

    private void attachAccountTypes(ModelMap modelMap) {
        modelMap.addAttribute("accountTypes", accountTypeRepository.findAll());
    }

    private void attachStatuses(ModelMap modelMap) {
        modelMap.addAttribute("states", stateRepository.findAll());
    }

}
