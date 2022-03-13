/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapaastral;

/**
 *
 * @author juran
 */
public class TimeZoneUF {
    public static int getTimeZOne(String UF, String cidade){
        Coordenadas coordenadas = new Coordenadas();
        switch(UF) {
            case "AC" -> {
                return -5;
            }
            case "AM" -> {
                double lon = coordenadas.getLongitude(cidade);
                double tabatingaLon = -69.9369;
                if(lon <= tabatingaLon){
                    return -5;
                }
                return -4;
            }
            case "MT","MS","RO","RR" -> {
                return -4;
            }
            case "ES", "PE","RN" -> {
                double lon = coordenadas.getLongitude(cidade);
                double fernandoDeNoronhaLon = -32.4188;
                if(lon <= fernandoDeNoronhaLon){
                    return -2;
                }
                return -3;
            }
            default -> {
                    return -3;
            }
        }
    }
    
}
