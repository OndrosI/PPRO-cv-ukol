package cz.uhk.ppro.inzeraty.controller;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inzerat-add")
public class InzeratFormController extends AbstractController{

    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmit(@RequestParam(value = "id", required = false) Integer id, @ModelAttribute("inzerat") Inzerat inzerat, BindingResult result) {
        if (result.hasErrors()) {
            return "inzeratForm";
        }
        if (id != null) {
            ulozisteInzeratu.odstran(id);
            inzerat.setId(id);
        }
        ulozisteInzeratu.pridej(inzerat);
        return "redirect:/inzeraty";

    }

    @RequestMapping(method = RequestMethod.GET)
    protected String form(@RequestParam(value = "id", required = false) Integer id, Model m) {
        if (id != null) {
            if (ulozisteInzeratu.getById(id).getHesloZadano()) {
                m.addAttribute("inzerat", ulozisteInzeratu.getById(id));
            } else {
                return "redirect:/inzeraty";
            }
        } else {
            m.addAttribute("inzerat", new Inzerat());
        }
        return "inzeratForm";
    }
}
