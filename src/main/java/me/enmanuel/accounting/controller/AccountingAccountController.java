package me.enmanuel.accounting.controller;

import me.enmanuel.accounting.entity.AccountingAccount;
import me.enmanuel.accounting.repository.AccountTypeRepository;
import me.enmanuel.accounting.repository.AccountingAccountRepository;
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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 6:17 PM
 */
@Controller
public class AccountingAccountController {

    @Autowired
    AccountingAccountRepository accountingAccountRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/accountingaccounts")
    public ModelAndView accountingAccount(ModelAndView modelAndView) {
        attachAccountingAccounts(modelAndView.getModelMap());
        modelAndView.setViewName("accountingaccounts");
        return modelAndView;
    }


    @RequestMapping(value = "/accountingaccount/{accountingAccountId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("accountingAccountId") AccountingAccount accountingAccount) {
        modelAndView.setViewName("accountingaccount");
        modelAndView.addObject("accountingAccount", accountingAccount);
        attachStatuses(modelAndView.getModelMap());
        attachMajorAccounts(modelAndView.getModelMap(), accountingAccount);
        attachAccountTypes(modelAndView.getModelMap());
        return modelAndView;
    }


    @PostMapping(value = "/accountingaccount")
    public ModelAndView save(ModelAndView modelAndView, AccountingAccount accountingAccount, RedirectAttributes redirectAttributes) {
        if (accountingAccount.getMajorAccount().getId() == null) {
            accountingAccount.setMajorAccount(null);
        }
        accountingAccountRepository.save(accountingAccount);
        redirectAttributes.addFlashAttribute("success", "El restaurante fue guardada correctamente");
        modelAndView.setViewName("redirect:/accountingaccounts");
        return modelAndView;
    }

    @RequestMapping(value = "/accountingaccount/delete/{accountingAccountId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer accountingAccountId,
                               RedirectAttributes redirectAttributes) {
        accountingAccountRepository.delete(accountingAccountId);
        redirectAttributes.addFlashAttribute("success", "El restaurante fue eliminado correctamente");
        modelAndView.setViewName("redirect:/accountingaccounts");
        return modelAndView;
    }

    @RequestMapping(value = "/accountingaccount/create")
    public ModelAndView create(ModelAndView modelAndView) {

        modelAndView.setViewName("accountingaccount");
        final AccountingAccount accountingAccount = new AccountingAccount();
        modelAndView.addObject("accountingAccount", accountingAccount);
        attachMajorAccounts(modelAndView.getModelMap(), accountingAccount);
        attachStatuses(modelAndView.getModelMap());
        attachAccountTypes(modelAndView.getModelMap());
        return modelAndView;
    }


    private void attachAccountingAccounts(ModelMap modelMap) {
        modelMap.addAttribute("accountingAccounts", accountingAccountRepository.findAll());
    }

    private void attachMajorAccounts(ModelMap modelMap, AccountingAccount accountingAccount) {
        List<AccountingAccount> l = (List<AccountingAccount>) accountingAccountRepository.findAll();
        l = l.stream().filter(x-> !Objects.equals(x.getId(), accountingAccount.getId())).collect(Collectors.toList());
        modelMap.addAttribute("majorAccounts", l);
    }

    private void attachStatuses(ModelMap modelMap) {
        modelMap.addAttribute("states", stateRepository.findAll());
    }

    private void attachAccountTypes(ModelMap modelMap) {
        modelMap.addAttribute("accountTypes", accountTypeRepository.findAll());
    }

}
