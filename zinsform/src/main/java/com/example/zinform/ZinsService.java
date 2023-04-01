package com.example.zinform;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@org.springframework.stereotype.Service
public class ZinsService {

    private List<ZinsJahre> list = new ArrayList<>();
    public Double endgeld;
    public List<ZinsJahre> zinsenBerechnen(interestForm zinsenForm) {
        Double anfangskapital = zinsenForm.anfangskapital();
        Double zinsProJahr;
        Double endkapital = null;

        for(int i=0; i < zinsenForm.laufzeit(); i++){
            zinsProJahr = Double.parseDouble(String.format(Locale.ENGLISH,"%.2f",anfangskapital * zinsenForm.zinssatz()/100));
            endkapital = Double.parseDouble(String.format(Locale.ENGLISH,"%.2f", anfangskapital + zinsProJahr));
            ZinsJahre zinsJahr = new ZinsJahre(i+1, anfangskapital, zinsProJahr, endkapital);
            list.add(zinsJahr);
            anfangskapital = endkapital;
        }
        endgeld = endkapital;

        return list;
    }
}