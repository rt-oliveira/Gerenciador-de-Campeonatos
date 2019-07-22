package FormatoCampeonato;

import Time.TimeMataMata;

public class Confronto {
    TimeMataMata t1;
    TimeMataMata t2;
    TimeMataMata vencedor;
    TimeMataMata perdedor;
    
    //0-time1 1-time2
    public void agregar(int a,int b,boolean ehprimeiro){
        if (ehprimeiro){//Eh primeiro true, 1o jogo, ou seja, t1 x t2
            t1.setGolsemcasa(a);
            t2.setGolsfora(b);
        }
        else{//False, segundo, ou seja, t2 x t1
            t2.setGolsemcasa(a);
            t1.setGolsfora(b);
        }
    }

    public TimeMataMata getT1() {
        return t1;
    }

    public TimeMataMata getT2() {
        return t2;
    }
    
    public Confronto(TimeMataMata t1,TimeMataMata t2){
        this.t1=t1;
        this.t2=t2;
        vencedor=null;
        perdedor=null;
    }

    public void vencedor() {
        if (t1.SomaDeGols()>t2.SomaDeGols()){
            vencedor=t1;
            perdedor=t2;
        }else if (t2.SomaDeGols()>t1.SomaDeGols()){
            vencedor=t2;
            perdedor=t1;
        }else{
            if (t1.getGolsfora()>t2.getGolsfora()){
                vencedor=t1;
                perdedor=t2;
            }else if (t2.getGolsfora()>t1.getGolsfora()){
                vencedor=t2;
                perdedor=t1;
            }else{
                vencedor=null;
                perdedor=null;
            }
        }
    }

    public void penaltis(String[] penaltis) {
        if (Integer.parseInt(penaltis[0])>Integer.parseInt(penaltis[1])){
            vencedor=t1;
            perdedor=t2;
        }else{
            vencedor=t2;
            perdedor=t1;
        }
    }
    
    public TimeMataMata getVencedor(){
        return vencedor;
    }
    
    public TimeMataMata getPerdedor(){
        return perdedor;
    }
}
