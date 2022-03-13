/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapaastral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author jurandi de almeida frança
 */
public class HorarioVerao {

    private ArrayList anoInicio;
    private ArrayList anoFim;
    private ArrayList dtInicio;
    private ArrayList dtFim;
    private ArrayList ondeVigorou;

    public HorarioVerao() {
        BufferedReader reader;
        anoInicio = new ArrayList();
        //anoFim = new ArrayList();
        dtInicio = new ArrayList();
        dtFim = new ArrayList();
        ondeVigorou = new ArrayList();

        try {
            reader = new BufferedReader(new FileReader("lib/HorarioVerao.CSV"));
            String linha = reader.readLine();
            String[] line;

            while (linha != null) {
                line = linha.split(";");
                anoInicio.add(line[0]);
                //anoFim.add(line[1]);
                dtInicio.add(line[2]);
                dtFim.add(line[3]);
                ondeVigorou.add(line[4]);
                linha = reader.readLine();
            }

            reader.close();

        } catch (IOException ex) {
            System.out.println("Não poder ler a base de coordenadas");
        }

    }

    public Boolean isHV(int dia, int mes, int ano, String uf) {
        // de 30/04 a 03/10 não tem horario de verão
        if (mes > 4 && mes < 10) {
            return false;
        }

        // acha o menor indice
        int idxMenor = anoInicio.indexOf(String.valueOf(ano - 1));
        if (idxMenor < 0) {
            idxMenor = anoInicio.indexOf(String.valueOf(ano));
        }

        // elimina anos que não teve horario de verão
        if (idxMenor < 0) {
            return false;
        }

        int idxMaior = anoInicio.lastIndexOf(String.valueOf(ano));
        // já eliminei no return anterior a possibilidade de não ser localizado;

        // prepara o comparador
        Calendar dtNasc = Calendar.getInstance();
        Calendar dtCompareA = Calendar.getInstance();
        Calendar dtCompareB = Calendar.getInstance();
        dtNasc.set(ano, mes, dia);

        for (int i = idxMenor; i <= idxMaior; i++) {
            if (vigorou(i, uf)) {
                String[] tmpData = dtInicio.get(i).toString().split("/");
                dtCompareA.set(Integer.parseInt(tmpData[2]), Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[0]));
                tmpData = dtFim.get(i).toString().split("/");
                dtCompareB.set(Integer.parseInt(tmpData[2]), Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[0]));
                if (dtNasc.after(dtCompareA) && dtNasc.before(dtCompareB)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean vigorou(int idxano, String uf) {
        String[] estados = ondeVigorou.get(idxano).toString().split(",");
        for (String estado : estados) {
            if ("TD".equals(estado) || uf.equals(estado)) {
                return true;
            }
        }
        return false;
    }
}
