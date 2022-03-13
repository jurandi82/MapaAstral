/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapaastral;

/**
 *
 * @author juran
 */
public class Casas {
    public static String casa(int graus){
        graus = graus /30;
        
        switch (graus) {
            case 0 -> {
                return "Áries";
            }
            case 1 -> {
                return "Touro";
            }
            case 2 -> {
                return "Gêmeos";
            }
            case 3 -> {
                return "Cancêr";
            }
            case 4 -> {
                return "Leão";
            }
            case 5 -> {
                return "Virgem";
            }
            case 6 -> {
                return "Libra";
            }
            case 7 -> {
                return "Escorpião";
            }
            case 8 -> {
                return "Sagitario";
            }
            case 9 -> {
                return "Capricornio";
            }
            case 10 -> {
                return "Aquario";
            }
            case 11 -> {
                return "Peixes";
            }
            default -> throw new AssertionError();
        }

    }
}
