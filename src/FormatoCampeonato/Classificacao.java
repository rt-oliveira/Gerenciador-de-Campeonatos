package FormatoCampeonato;

import Time.TimePontosCorridos;
import Time.Time;
import java.util.Comparator;

public class Classificacao implements Comparator<Time>{
    
    @Override
    public int compare(Time t1, Time t2) {
        TimePontosCorridos o1=(TimePontosCorridos) t1;
        TimePontosCorridos o2=(TimePontosCorridos) t2;
        /*Critérios de ordenação:
        1o - + Pontos
        2o - + Vitorias
        3o - + Empates
        4o - - Derrotas
        5o - + Saldo de Gols
        6o - Nome*/
        int r;
        if (o1.getPontos()==o2.getPontos())
            if (o1.getVitorias()==o2.getVitorias())
                if (o1.getEmpates()==o2.getEmpates())
                    if (o1.getDerrotas()==o2.getDerrotas())
                        if (o1.getSaldodegols()==o2.getSaldodegols())
                            r=-o1.getNome().compareTo(o2.getNome());
                        else
                            r=o1.getSaldodegols()-o2.getSaldodegols();
                    else
                        r=o1.getDerrotas()-o2.getDerrotas();
                else
                    r=o1.getEmpates()-o2.getEmpates();
            else
                r=o1.getVitorias()-o2.getVitorias();
        else
            r=o1.getPontos()-o2.getPontos();
        return r;
    }
    
}
