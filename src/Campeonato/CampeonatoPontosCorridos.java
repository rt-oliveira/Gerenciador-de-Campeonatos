package Campeonato;

import FormatoCampeonato.Classificacao;
import Time.TimePontosCorridos;
import java.util.Collections;

public class CampeonatoPontosCorridos extends Campeonato{
    
    @Override
    public Object[][] ToArray(){
        Object[][] a=new Object[times.size()][7];
        for (int i = 0; i < times.size(); i++) {
            TimePontosCorridos tpc=(TimePontosCorridos) times.get(i);
            a[i][0]=i+1;
            a[i][1]=tpc.getNome();
            a[i][2]=tpc.getPontos();
            a[i][3]=tpc.getVitorias();
            a[i][4]=tpc.getEmpates();
            a[i][5]=tpc.getDerrotas();
            a[i][6]=tpc.getSaldodegols();
        }
        return a;
    }
    
    @Override
    public void AtribuirResultado(Object... dados){
        String[] a=(String[]) dados[0];
        int golscasa=Integer.parseInt(a[0]);
        int golsvisitante=Integer.parseInt(a[1]);
        TimePontosCorridos c=(TimePontosCorridos)times.get((int)dados[1]);
        TimePontosCorridos v=(TimePontosCorridos)times.get((int)dados[2]);
        if (golscasa==golsvisitante){
            Empate(c,(int)dados[1]);
            Empate(v,(int)dados[2]);
        }
        else if (golscasa>golsvisitante){
            Vitoria(c,(int)dados[1],golscasa-golsvisitante);
            Derrota(v,(int)dados[2],golscasa-golsvisitante);
        }
        else{
            Vitoria(v,(int)dados[2],golsvisitante-golscasa);
            Derrota(c,(int)dados[1],golsvisitante-golscasa);
        }
        MudarClassificacao();
    }
    
    void Empate(TimePontosCorridos t,int indice){
        t.setPontos(t.getPontos()+1);
        t.setEmpates();
        times.set(indice, t);
    }
    
    void Vitoria(TimePontosCorridos t,int indice,int saldo){
        t.setPontos(t.getPontos()+3);
        t.setVitorias();
        t.setSaldodegols(saldo);
        times.set(indice,t);
    }
    
    void Derrota(TimePontosCorridos t,int indice,int saldo){
        t.setDerrotas();
        t.setSaldodegols(-saldo);
        times.set(indice,t);
    }
    
    public void MudarClassificacao(){
        times.sort(new Classificacao());
        Collections.reverse(times);
    }

    @Override
    public void CadastrarEquipe(String nome){
        times.add(new TimePontosCorridos(nome));
    }
}
