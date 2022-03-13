/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapaastral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author juran
 */
public class Coordenadas {

    private ArrayList estado;
    private ArrayList cidade;
    private ArrayList lat;
    private ArrayList lon;

    public Coordenadas() {
        estado = new ArrayList();
        cidade = new ArrayList();
        lat = new ArrayList();
        lon = new ArrayList();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("lib/latlon.csv"));
            String linha = reader.readLine();
            String[] line;

            while (linha != null) {
                line = linha.split(",");
                estado.add(line[0]);
                cidade.add(line[1]);
                lat.add(line[2]);
                lon.add(line[3]);
                linha = reader.readLine();
            }
            reader.close();

        } catch (IOException ex) {
            System.out.println("Não poder ler a base de coordenadas");
        }
    }

    /**
     * Pega as cidades de um estado
     *
     * @param UF
     * @return ArrayList
     */
    public ArrayList getCidades(String UF) {
        ArrayList cidades = new ArrayList();
        int inicio = estado.indexOf(UF);
        int fim = estado.lastIndexOf(UF);
        for (int i = inicio; i < fim; i++) {
            cidades.add(cidade.get(i));
        }
        return cidades;
    }

    /**
     * Pega a latitude
     *
     * @param localidade
     * @return double
     */
    public double getLatitude(String localidade) {
        int i = cidade.indexOf(localidade);
        return Double.parseDouble(lat.get(i).toString());
    }

    /**
     * Pega a longitude
     *
     * @param localidade
     * @return double
     */
    public double getLongitude(String localidade) {
        int i = cidade.indexOf(localidade);
        return Double.parseDouble(lon.get(i).toString());
    }

}
