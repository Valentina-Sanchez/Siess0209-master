package co.example.prueba.consumo;

public class Usuario {

    private Object pkUsuario;
    private String nombreusuario;
    private String contrasena;
    private int tipousuarioenum;
    private Object pkPersona;


    public  Usuario(){

    }
    public Usuario(Object pkUsuario, String nombreusuario, String contrasena, int tipousuarioenum, Object pkPersona) {
        this.pkUsuario = pkUsuario;
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
        this.tipousuarioenum = tipousuarioenum;
        this.pkPersona = pkPersona;
    }

    public Object getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(Object pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTipousuarioenum() {
        return tipousuarioenum;
    }

    public void setTipousuarioenum(int tipousuarioenum) {
        this.tipousuarioenum = tipousuarioenum;
    }

    public Object getPkPersona() {
        return pkPersona;
    }

    public void setPkPersona(Object pkPersona) {
        this.pkPersona = pkPersona;
    }
}
