package cz.uhk.ppro.inzeraty.controller;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inzerat-confirm")
public class InzeratConfirmController extends AbstractController{

    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmit(@RequestParam(value = "id", required = false) Integer id,
                              @RequestParam("heslo") String heslo,
                              @RequestParam(value = "akce", required = false) String akce,
                              @ModelAttribute("inzerat") Inzerat inzerat,
                              BindingResult result) {
        if (id != null && heslo != null) {
            if (ulozisteInzeratu.getById(id).getHesloProUpravu().equals(heslo)) {
                ulozisteInzeratu.getById(id).setHesloZadano(true);
                if (akce != null && akce.equals("remove")) {
                    return "redirect:/inzerat-delete?id=" + id;
                }
                return "redirect:/inzerat-add?id=" + id;
            }
        }

        return "redirect:/inzeraty";

    }

    @RequestMapping(method = RequestMethod.GET)
    protected String form(@RequestParam(value = "id", required = false) Integer id, Model m) {
        if (id != null) {
            m.addAttribute("inzerat", ulozisteInzeratu.getById(id));
            return "confirmForm";
        }
        return "inzeraty";
    }
}
