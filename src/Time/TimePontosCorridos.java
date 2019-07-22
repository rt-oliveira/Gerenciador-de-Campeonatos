package Time;

public class TimePontosCorridos extends Time{
    private int pontos;
    private int saldodegols;
    private int vitorias;
    private int empates;
    private int derrotas;

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getSaldodegols() {
        return saldodegols;
    }

    public void setSaldodegols(int saldodegols) {
        this.saldodegols+=saldodegols;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias() {
        this.vitorias++;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates() {
        this.empates++;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas() {
        this.derrotas++;
    }

    public TimePontosCorridos(String nome) {
        this.nome=nome;
        pontos=0;
        saldodegols=0;
        vitorias=0;
        empates=0;
        derrotas=0;
    }
    
    public Object[] ToArray(int i){
        Object[] p=new Object[3];
        p[0]=i;
        p[1]=nome;
        p[2]=pontos;
        return p;
    }
}
