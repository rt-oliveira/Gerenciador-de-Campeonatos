package Campeonato;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public abstract class Campeonato {
    protected ArrayList times;
    
    public Campeonato(){
        times=new ArrayList<>();
    }

    public ArrayList getTimes() {
        return times;
    }
    
    //String[] placar,int indicecasa,int indicevisitante
    public abstract void AtribuirResultado(Object... dados);
    public abstract void CadastrarEquipe(String nome);
    public abstract Object[][] ToArray();
    
    public DefaultTableModel GerarTabela(TableModel tm,Object[] colunas){
        DefaultTableModel dtm=(DefaultTableModel) tm;
        dtm.setDataVector(ToArray(), colunas);
        return dtm;
    }
}
