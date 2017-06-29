package me.enmanuel.accounting.controller;

import me.enmanuel.accounting.entity.AccountType;
import me.enmanuel.accounting.entity.Auxiliary;
import me.enmanuel.accounting.repository.AuxiliaryRepository;
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
 * User: enmanuelreyes
 * Date: 6/29/17
 * Time: 6:42 PM
 */
@Controller
public class AuxiliaryController {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private AuxiliaryRepository auxiliaryRepository;


    @GetMapping("/auxiliaries")
    public ModelAndView accountingAccount(ModelAndView modelAndView) {
        attachAuxiliaries(modelAndView.getModelMap());
        modelAndView.setViewName("auxiliaries");
        return modelAndView;
    }


    @RequestMapping(value = "/auxiliary/{auxiliaryId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("auxiliaryId")Auxiliary auxiliary) {
        modelAndView.setViewName("auxiliary");
        modelAndView.addObject("auxiliary", auxiliary);
        attachStatuses(modelAndView.getModelMap());
        return modelAndView;
    }


    @PostMapping(value = "/auxiliary")
    public ModelAndView save(ModelAndView modelAndView, Auxiliary auxiliary, RedirectAttributes redirectAttributes) {
        auxiliaryRepository.save(auxiliary);
        redirectAttributes.addFlashAttribute("success", "El Auxiliar fue guardada correctamente");
        modelAndView.setViewName("redirect:/auxiliaries");
        return modelAndView;
    }


    @RequestMapping(value = "/auxiliary/create")
    public ModelAndView create(ModelAndView modelAndView) {

        modelAndView.setViewName("auxiliary");
        modelAndView.addObject("auxiliary", new Auxiliary());
        attachStatuses(modelAndView.getModelMap());
        return modelAndView;
    }


    @RequestMapping(value = "/auxiliary/delete/{auxiliaryId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer auxiliaryId,
                               RedirectAttributes redirectAttributes) {
        auxiliaryRepository.delete(auxiliaryId);
        redirectAttributes.addFlashAttribute("success", "El Auxiliar fue eliminado correctamente");
        modelAndView.setViewName("redirect:/auxiliaries");
        return modelAndView;
    }


    private void attachAuxiliaries(ModelMap modelMap) {
        modelMap.addAttribute("auxiliaries", auxiliaryRepository.findAll());
    }


    private void attachStatuses(ModelMap modelMap) {
        modelMap.addAttribute("states", stateRepository.findAll());
    }

}
