package cz.uhk.ppro.inzeraty;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;

@SpringBootApplication
public class InzeratyApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(InzeratyApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // namapovat URL / na view jmenem index (tedy pres view-resolver na /WEB-INF/jsp/index.jsp)
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    @Primary
    PametoveUlozisteInzeratu getUlozisteInzeratu()
    {
        PametoveUlozisteInzeratu pui = new PametoveUlozisteInzeratu();
        Inzerat inzerat = new Inzerat();
        inzerat.setId(1);
        inzerat.setKategorie("prodej");
        inzerat.setText("Kolo");
        inzerat.setCena(new BigDecimal("2000"));
        inzerat.setHesloProUpravu("Heslo");
        pui.pridej(inzerat);

        Inzerat inzerat2 = new Inzerat();
        inzerat2.setId(2);
        inzerat2.setKategorie("vymena");
        inzerat2.setText("Mobil");
        inzerat2.setCena(new BigDecimal("4000"));
        inzerat2.setHesloProUpravu("Heslo2");
        pui.pridej(inzerat2);

        Inzerat inzerat3 = new Inzerat();
        inzerat3.setId(3);
        inzerat3.setKategorie("nakup");
        inzerat3.setText("PC");
        inzerat3.setCena(new BigDecimal("25000"));
        inzerat3.setHesloProUpravu("Heslo3");
        pui.pridej(inzerat3);

        return pui;
    }
}
