package co.example.prueba.consumo;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.example.prueba.modelo.Ficha;
import co.example.prueba.modelo.Municipio;
import co.example.prueba.modelo.Responsable;

public class Prestamo {

    private String codigo;
   private String fechasolicitud;
    private String fechasalida;
    private String fechadevolucion;
    private short estado;
    private String observacion;
    private Ficha fkFicha;
    private Municipio fkMunicipio;
    private Responsable fkResponsable;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Prestamo(String fechasolicitud, String fechasalida, String fechadevolucion, short estado, String observacion, Ficha fkFicha, Municipio fkMunicipio, Responsable fkResponsable , String codigo) {
        this.fechasolicitud = fechasolicitud;
        this.fechasalida = fechasalida;
        this.fechadevolucion = fechadevolucion;
        this.estado = estado;
        this.observacion = observacion;
        this.fkFicha = fkFicha;
        this.fkMunicipio = fkMunicipio;
        this.fkResponsable = fkResponsable;
        this.codigo = codigo;
    }

    public String getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(String fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String descripcion) {
        this.observacion = descripcion;
    }

    public Ficha getFk_ficha() {
        return fkFicha;
    }

    public void setFk_ficha(Ficha fk_ficha) {
        this.fkFicha = fk_ficha;
    }

    public Municipio getFk_municipio() {
        return fkMunicipio;
    }

    public void setFk_municipio(Municipio fk_municipio) {
        this.fkMunicipio = fkMunicipio;
    }

    public Responsable getFk_responsable() {
        return fkResponsable;
    }

    public void setFk_responsable(Responsable fkResponsable) {
        this.fkResponsable = fkResponsable;
    }

    public Prestamo() {
    }

}
