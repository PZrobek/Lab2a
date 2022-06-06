package pl.lublin.wsei.java.cwiczenia.lab2a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String tytul, adresStrony, adresGrafiki, adresMiniaturki;
    public int szerokosc, wysokosc;

    public Infografika(String tekst) {
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find())
            tytul = m.group(1);
        else
            tytul = "";

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
        if (m.find())
            adresStrony = m.group(1);
        else
            adresStrony = "";

        pat = Pattern.compile("<media:content url=\"(.*)\" type");
        m = pat.matcher(tekst);
        if (m.find())
            adresGrafiki = m.group(1);
        else
            adresGrafiki = "";

        pat = Pattern.compile("<media:thumbnail url=\"(.*)\" />");
        m = pat.matcher(tekst);
        if (m.find())
            adresMiniaturki = m.group(1);
        else
            adresMiniaturki = "";

        pat = Pattern.compile("type=\"image/png\" width=\"(.*)\" height");
        m = pat.matcher(tekst);
        if (m.find())
            szerokosc = Integer.parseInt(m.group(1));
        else
            szerokosc = 0;

        pat = Pattern.compile("height=\"(.*)\">");
        m = pat.matcher(tekst);
        if (m.find())
            wysokosc = Integer.parseInt(m.group(1));
        else
            wysokosc = 0;
    }

    public void print() {

        System.out.print("\nInfografika: \ntytul: "+tytul
                +"\nadres strony: "+adresStrony
                +"\nadres grafiki: "+adresGrafiki
                +"\nadres miniaturki: "+adresMiniaturki
                +"\nrozmiary: "+szerokosc+"x"+wysokosc+"\n");
    }
}
