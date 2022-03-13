/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapaastral;

import at.kugel.zodiac.TextHoroscop;
import at.kugel.zodiac.house.HousePlacidus;
import at.kugel.zodiac.planet.PlanetAA0;

/**
 *
 * @author juran
 */
public class Mapa {
    TextHoroscop horoscop;
    
    public Mapa(){
        horoscop = new TextHoroscop();
        horoscop.setPlanet(new PlanetAA0());
        horoscop.setHouse(new HousePlacidus());
    }
    
  
    public String calcValues(int dia, int mes, int ano, int hora, int min, int gmt, double lat, double lon){
        horoscop.setTime(dia, mes, ano, hora, min, 0, gmt);
        horoscop.setLocation(lat, lon);
        horoscop.calcValues();
        String txt=horoscop.toString();
        String tmptxt="";        
        tmptxt+=localiza("Sun:","☀ Sol:", txt);
        tmptxt+=localiza("Moon:","🌙 Lua:", txt);
        tmptxt+=localiza("AC:","Ascendente:", txt);
        tmptxt+=localiza("Mercury:","☿ Mercúrio:", txt);
        tmptxt+=localiza("Venus:","♀ Vênus:", txt);
        tmptxt+=localiza("Mars:","♂ Marte:", txt);
        tmptxt+=localiza("Jupiter:","♃ Jupiter:", txt);
        tmptxt+=localiza("Saturn:","♄ Saturno:", txt);
        tmptxt+=localiza("Uranus:","♅ Urano:", txt);
        tmptxt+=localiza("Neptune:","♆ Netuno:", txt);
        tmptxt+=localiza("Pluto:","♇ Plutão:", txt);
        
        return tmptxt;
    }
    
    private static String localiza(String item, String subst, String Texto) {
        String txt = Texto;       
        int ini = txt.indexOf(item) + item.length();
        int fim = txt.indexOf(";", ini);
        txt= txt.substring(ini, fim);        
        ini = Integer.parseInt(txt.split("°")[0]);
        txt = txt.split("°")[1];       
        return  subst+" em "+ Casas.casa(ini / 30 + 1) + " posição: "+ ini % 30 + "°" + txt+"\n";
    }
    
    
    
}
