package cz.uhk.ppro.inzeraty.controller;

import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public abstract class AbstractController {
    PametoveUlozisteInzeratu ulozisteInzeratu = null;

    public PametoveUlozisteInzeratu getUlozisteInzeratu() {
        return ulozisteInzeratu;
    }

    @Autowired
    public void setUlozisteInzeratu(PametoveUlozisteInzeratu ulozisteInzeratu) {
        this.ulozisteInzeratu = ulozisteInzeratu;
    }
}
