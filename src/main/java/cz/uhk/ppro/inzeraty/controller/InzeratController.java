package cz.uhk.ppro.inzeraty.controller;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InzeratController extends AbstractController{

    @RequestMapping("/inzeraty")
    @ResponseBody
    public ModelAndView zobrazit(@RequestParam(value = "kategorie", required = false) String kategorie) {
        ModelAndView model = new ModelAndView("inzeraty");

        if(kategorie != null){
            model.addObject("inzerat", ulozisteInzeratu.getInzeratyByKategorie(kategorie));
        } else {
            model.addObject("inzerat", ulozisteInzeratu.getInzeraty());
        }

        for (Inzerat inzerat : ulozisteInzeratu.getInzeraty()) {
            inzerat.setHesloZadano(false);
            System.out.println(inzerat.getHesloProUpravu());
        }
        return model;
    }

    @RequestMapping("/inzerat-delete")
    public String delete(@RequestParam(value = "id") Integer id) {
        if (id != null && ulozisteInzeratu.getById(id).getHesloZadano()) {
            ulozisteInzeratu.odstran(ulozisteInzeratu.getById(id));
        }
        return "redirect:/inzeraty";
    }
}
