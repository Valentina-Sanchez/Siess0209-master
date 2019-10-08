package co.example.prueba.consumo;

import co.example.prueba.modelo.Ficha;
import co.example.prueba.modelo.Municipio;
import co.example.prueba.modelo.Responsable;

public class PojoPrestamo {

    private String codigo;
    private String fechasolicitud;
    private String fechasalida;
    private String fechadevolucion;
    private short estado;
    private String observacion;
    private String fkFicha;
    private String fkMunicipio;
    private String fkResponsable;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public PojoPrestamo(String fechasolicitud, String fechasalida, String fechadevolucion, short estado, String observacion, String fkFicha, String fkMunicipio, String fkResponsable , String codigo) {
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

    public String getFk_ficha() {
        return fkFicha;
    }

    public void setFk_ficha(String fk_ficha) {
        this.fkFicha = fk_ficha;
    }

    public String getFk_municipio() {
        return fkMunicipio;
    }

    public void setFk_municipio(String fk_municipio) {
        this.fkMunicipio = fk_municipio;
    }

    public String getFk_responsable() {
        return fkResponsable;
    }

    public void setFk_responsable(String fkResponsable) {
        this.fkResponsable = fkResponsable;
    }

    public PojoPrestamo() {
    }

}

