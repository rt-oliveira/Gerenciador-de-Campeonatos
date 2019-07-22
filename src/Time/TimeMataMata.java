package Time;

public class TimeMataMata extends Time{
    private int golsfora;
    private int golsemcasa;
    
    public void Zerar(){
        golsfora=0;
        golsemcasa=0;
    }

    public int getGolsfora() {
        return golsfora;
    }

    public void setGolsfora(int golsfora) {
        this.golsfora+= golsfora;
    }

    public int getGolsemcasa() {
        return golsemcasa;
    }

    public void setGolsemcasa(int golsemcasa) {
        this.golsemcasa+= golsemcasa;
    }
    
    public int SomaDeGols(){
        return golsfora+golsemcasa;
    }
    
    public TimeMataMata(String nome){
        this.nome=nome;
        golsfora=0;
        golsemcasa=0;
    }
}
