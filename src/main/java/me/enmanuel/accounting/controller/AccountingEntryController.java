package me.enmanuel.accounting.controller;

import me.enmanuel.accounting.service.AccountingEntryService;
import me.enmanuel.accounting.entity.*;
import me.enmanuel.accounting.repository.AccountingAccountRepository;
import me.enmanuel.accounting.repository.AccountingEntryRepository;
import me.enmanuel.accounting.repository.AuxiliaryRepository;
import me.enmanuel.accounting.repository.StateRepository;
import me.enmanuel.accounting.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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
    AccountingEntryService accountingEntryService;


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
        accountingEntry.setAuxiliary(Util.toList(auxiliaryRepository.findAll()).get(0));
        modelAndView.addObject("accountingEntry", accountingEntry);
        attachStatuses(modelAndView.getModelMap());
        attachAccountingAccounts(modelAndView.getModelMap());
        attachAuxiliaries(modelAndView.getModelMap());
        return modelAndView;
    }


    @RequestMapping(value = "/accountingentry/{accountingEntryId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("accountingEntryId") AccountingEntry accountingEntry) {
        modelAndView.setViewName("accountingentry");
        modelAndView.addObject("accountingEntry", accountingEntry);
        attachStatuses(modelAndView.getModelMap());
        attachAccountingAccounts(modelAndView.getModelMap());
        attachAuxiliaries(modelAndView.getModelMap());

        return modelAndView;
    }


    @PostMapping(value = "/accountingentry",  params = {"save"})
    public ModelAndView save(ModelAndView modelAndView, AccountingEntry accountingEntry, RedirectAttributes redirectAttributes) {
        accountingEntry.setAuxiliary(Util.toList(auxiliaryRepository.findAll()).get(0));
        try {
            accountingEntryService.save(accountingEntry);
            redirectAttributes.addFlashAttribute("success", "La entrada contable fue guardada correctamente");
            modelAndView.setViewName("redirect:/accountingentries");

        }
        catch (Exception e) {
            modelAndView.addObject("error", e.getMessage());
            attachAccountingAccounts(modelAndView.getModelMap());
            attachAuxiliaries(modelAndView.getModelMap());
            attachStatuses(modelAndView.getModelMap());
        }
        return modelAndView;
    }


    @PostMapping(value = "/accountingentry",  params = {"addTransaction"})
    public ModelAndView addTransaction(ModelAndView modelAndView, AccountingEntry accountingEntry) {
        if (accountingEntry.getTransactions() == null)
            accountingEntry.setTransactions(new ArrayList<>());
        accountingEntry.getTransactions().add(new Transaction());
        attachAccountingAccounts(modelAndView.getModelMap());
        attachAuxiliaries(modelAndView.getModelMap());
        attachStatuses(modelAndView.getModelMap());

        return modelAndView;
    }


    @PostMapping(value = "/accountingentry",  params = {"removeTransaction"})
    public ModelAndView deleteTransaction(ModelAndView modelAndView, AccountingEntry accountingEntry, HttpServletRequest req) {
        int rowId = Integer.valueOf(req.
                getParameter("removeTransaction"));

        accountingEntry.getTransactions().remove(rowId);
        attachAccountingAccounts(modelAndView.getModelMap());
        attachAuxiliaries(modelAndView.getModelMap());
        attachStatuses(modelAndView.getModelMap());

        return modelAndView;
    }


    @RequestMapping(value = "/accountingentry/delete/{accountingEntryId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer accountingEntryId,
                               RedirectAttributes redirectAttributes) {
        accountingEntryRepository.delete(accountingEntryId);
        redirectAttributes.addFlashAttribute("success", "La entrada contable fue eliminada correctamente");
        modelAndView.setViewName("redirect:/accountingentries");
        return modelAndView;
    }

    @PostMapping("/api/accountingentry")
    public ResponseEntity<String> apiSave(@RequestBody AccountingEntry accountingEntry) {
        ResponseEntity<String> r;
        accountingEntry.setState(State.ACTIVE);
        try {
            accountingEntryService.save(accountingEntry);
            r = ResponseEntity.ok(accountingEntry.getId().toString());
        } catch (Exception ex) {
            r = ResponseEntity.badRequest().body(ex.getMessage());
        }
        return r;
    }
    @GetMapping("/api/accountingentry")
    public ResponseEntity<String> apiSave() {
        ResponseEntity<String> r;
        try {
            r = ResponseEntity.ok("Hello");
        }catch (Exception ex){
            r = ResponseEntity.badRequest().body(ex.getMessage());
        }
        return r;
    }


    private void attachStatuses(ModelMap modelMap) {
        modelMap.addAttribute("states", stateRepository.findAll());
    }


    private void attachAuxiliaries(ModelMap modelMap) {

        modelMap.addAttribute("auxiliaries", auxiliaryRepository.findAll());
    }

    private void attachAccountingEntries(ModelMap modelMap) {
        modelMap.addAttribute("accountingEntries", accountingEntryRepository.findAll());

    }


    private void attachAccountingAccounts(ModelMap modelMap) {
        modelMap.addAttribute("accountingAccounts", accountingAccountRepository.findByAllowTransactionsTrue());
    }


}
