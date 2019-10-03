package co.example.prueba.modelo;

public class Ficha {

    private int pkFicha;
    private String codigo;

    public Ficha() {
    }

    public int getPkFicha() {
        return pkFicha;
    }

    public void setPkFicha(int pkFicha) {
        this.pkFicha = pkFicha;
    }

    public Ficha(int pkFicha, String codigo) {
        this.pkFicha = pkFicha;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
