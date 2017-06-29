package me.enmanuel.accounting.controller;

import me.enmanuel.accounting.entity.AccountingAccount;
import me.enmanuel.accounting.entity.AccountingEntry;
import me.enmanuel.accounting.repository.AccountingAccountRepository;
import me.enmanuel.accounting.repository.AccountingEntryRepository;
import me.enmanuel.accounting.repository.AuxiliaryRepository;
import me.enmanuel.accounting.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 23-Jun-17
 * Time: 11:14 AM
 */
@Controller
public class AccountingEntryController {

    @Autowired
    AccountingEntryRepository accountingEntryRepository;


    @Autowired
    AccountingAccountRepository accountingAccountRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private AuxiliaryRepository auxiliaryRepository;

    @GetMapping("/accountingentries")
    public ModelAndView accountingAccount(ModelAndView modelAndView) {
        attachAccountingEntries(modelAndView.getModelMap());
        modelAndView.setViewName("accountingentries");
        return modelAndView;
    }


    @RequestMapping(value = "/accountingentry/create")
    public ModelAndView create(ModelAndView modelAndView) {

        modelAndView.setViewName("accountingentry");
        final AccountingEntry accountingEntry = new AccountingEntry();
        modelAndView.addObject("accountingEntry", accountingEntry);
        attachStatuses(modelAndView.getModelMap());
        attachAccountingAccounts(modelAndView.getModelMap());
        return modelAndView;
    }


    @RequestMapping(value = "/accountingentry/{accountingEntryId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("accountingEntryId") AccountingEntry accountingEntry) {
        modelAndView.setViewName("accountingentry");
        modelAndView.addObject("accountingEntry", accountingEntry);
        attachStatuses(modelAndView.getModelMap());
        attachAccountingAccounts(modelAndView.getModelMap());
        return modelAndView;
    }


    @PostMapping(value = "/accountingentry")
    public ModelAndView save(ModelAndView modelAndView, AccountingEntry accountingEntry, RedirectAttributes redirectAttributes) {
        accountingEntry.setDate(LocalDateTime.now());
        accountingEntryRepository.save(accountingEntry);
        redirectAttributes.addFlashAttribute("success", "El restaurante fue guardada correctamente");
        modelAndView.setViewName("redirect:/accountingentries");
        return modelAndView;
    }

    @RequestMapping(value = "/accountingentry/delete/{accountingEntryId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer accountingEntryId,
                               RedirectAttributes redirectAttributes) {
        accountingEntryRepository.delete(accountingEntryId);
        redirectAttributes.addFlashAttribute("success", "El restaurante fue eliminado correctamente");
        modelAndView.setViewName("redirect:/accountingentries");
        return modelAndView;
    }

    @PostMapping("/api/accountingentry")
    public ResponseEntity saveUsing(AccountingEntry accountingEntry) {
        return ResponseEntity.ok().build();
    }

    private void attachStatuses(ModelMap modelMap) {
        modelMap.addAttribute("states", stateRepository.findAll());
    }


    private void attachAuxiliaries(ModelMap modelMap) {
        modelMap.addAttribute("states", auxiliaryRepository.findAll());
    }

    private void attachAccountingEntries(ModelMap modelMap) {
        modelMap.addAttribute("accountingEntries", accountingEntryRepository.findAll());

    }


    private void attachAccountingAccounts(ModelMap modelMap) {
        modelMap.addAttribute("accountingAccounts", accountingAccountRepository.findAll());
    }


}
