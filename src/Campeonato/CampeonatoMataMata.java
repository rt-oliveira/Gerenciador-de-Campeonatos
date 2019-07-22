package Campeonato;

import FormatoCampeonato.Confronto;
import Time.TimeMataMata;
import java.util.*;

public class CampeonatoMataMata extends Campeonato {
    
    private final ArrayList<Confronto> destafase;
    private final Random r=new Random();
    
    public CampeonatoMataMata(){
        super();
        destafase=new ArrayList<>();
    }

    public void GerarConfrontos() {
        ArrayList<TimeMataMata> t=(ArrayList<TimeMataMata>) times.clone();
        Collections.shuffle(t);
        while (!t.isEmpty()){
            destafase.add(new Confronto(t.get(0),t.get(1)));
            t.remove(t.get(0));
            t.remove(t.get(0));
        }
    }

    @Override
    public void CadastrarEquipe(String nome){
        times.add(new TimeMataMata(nome));
    }

    public String MostrarConfrontosDaFase() {
        int a=destafase.size(); String f;
        if (a==8)
            f="Os confrontos das oitavas-de-final são:\n";
        else if (a==4)
            f="Os confrontos das quartas-de-final são:\n";
        else if (a==2)
            f="Os confrontos das semi-finais são:\n";
        else
            f="O confronto da grande final é:\n";
        for (Confronto c : destafase)
            f+=String.format("%s x %s\n", c.getT1().getNome(),c.getT2().getNome());
        return f;
    }

    @Override
    public Object[][] ToArray() {
        Object[][] a=new Object[destafase.size()][3];
        for (int i = 0; i < destafase.size(); i++) {
            Confronto c=destafase.get(i);
            a[i][0]=c.getT1().getNome();
            a[i][1]="x";
            a[i][2]=c.getT2().getNome();
        }
        return a;
    }

    @Override
    public void AtribuirResultado(Object... dados) {
        Confronto c=destafase.get((int)dados[2]);
        //1o Jogo: t1 x t2, ou seja, t2 fora
        String[] j1=(String[]) dados[0];
        String[] j2=(String[]) dados[1];
        c.agregar(Integer.parseInt(j1[0]), Integer.parseInt(j1[1]), true);
        c.agregar(Integer.parseInt(j2[0]), Integer.parseInt(j2[1]), false);
        destafase.set((int)dados[2],c);
    }

    public String DeterminarVencedorDoConfronto(int a,String t1,String t2) {
        Confronto c=destafase.get(a);
        c.vencedor();
        if (c.getVencedor()==null){
                String[] penaltis=javax.swing.JOptionPane.showInputDialog(null, "O confronto terminou empatado, mesmo número de gols feitos e gols fora de casa. \nSerá decidido nos pênalts. Qual foi o placar nos pênaltis?\n Formato: pênaltis convertidos pelo(a) "+t1+"-pênaltis convertidos pelo(a) "+t2, "Decisão nos pênaltis", javax.swing.JOptionPane.INFORMATION_MESSAGE).split("-");
                c.penaltis(penaltis);
        }
        String v=c.getVencedor().getNome();
        javax.swing.JOptionPane.showMessageDialog(null, "O vencedor foi o(a) "+v);
        Eliminar(a);
        return v;
    }

    public void Eliminar(int a) {
        Confronto c=destafase.get(a);
        times.remove(c.getPerdedor());
        destafase.remove(c);
    }
    
    public int ConfrontosRestantes(){
        return destafase.size();
    }

    public String TimesClassificados() {
        String t="";
        for (Object time : times)
            t += ((TimeMataMata) time).getNome() + "\n";
        return t;
    }
   
    public void Confronto(String t1, String t2,int a) {
        String[] placarj1=javax.swing.JOptionPane.showInputDialog(String.format("Resultado da partida entre %s e %s\nFormato de entrada: gols feitos pelo(a) %s-gols feitos pelo(a) %s",t1,t2,t1,t2)).split("-");
        String[] placarj2=javax.swing.JOptionPane.showInputDialog(String.format("Resultado da partida entre %s e %s\nFormato de entrada: gols feitos pelo(a) %s-gols feitos pelo(a) %s",t2,t1,t2,t1)).split("-");
        AtribuirResultado(placarj1,placarj2,a);
    }

    public void ZerarTimes(){
        for (Object tmm:times)
            ((TimeMataMata)tmm).Zerar();
    }
}
