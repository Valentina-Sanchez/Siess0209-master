package co.example.prueba.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoPrestamo {


    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("fechasolicitud")
    @Expose
    private Integer fechasolicitud;
    @SerializedName("fechasalida")
    @Expose
    private Integer fechasalida;
    @SerializedName("fechadevolucion")
    @Expose
    private Integer fechadevolucion;
    @SerializedName("estado")
    @Expose
    private Integer estado;
    @SerializedName("observacion")
    @Expose
    private String observacion;
    @SerializedName("fkFicha")
    @Expose
    private FkFicha fkFicha;
    @SerializedName("fkMunicipio")
    @Expose
    private FkMunicipio fkMunicipio;
    @SerializedName("fkResponsable")
    @Expose
    private FkResponsable fkResponsable;
    @SerializedName("creadopor")
    @Expose
    private Integer creadopor;

    public PojoPrestamo(){

    }


    public PojoPrestamo( String codigo, Integer fechasolicitud, Integer fechasalida, Integer fechadevolucion, Integer estado, String observacion, FkFicha fkFicha, FkMunicipio fkMunicipio, FkResponsable fkResponsable, Integer creadopor) {

        this.codigo = codigo;
        this.fechasolicitud = fechasolicitud;
        this.fechasalida = fechasalida;
        this.fechadevolucion = fechadevolucion;
        this.estado = estado;
        this.observacion = observacion;
        this.fkFicha = fkFicha;
        this.fkMunicipio = fkMunicipio;
        this.fkResponsable = fkResponsable;
        this.creadopor = creadopor;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(Integer fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public Integer getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Integer fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Integer getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Integer fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public FkFicha getFkFicha() {
        return fkFicha;
    }

    public void setFkFicha(FkFicha fkFicha) {
        this.fkFicha = fkFicha;
    }

    public FkMunicipio getFkMunicipio() {
        return fkMunicipio;
    }

    public void setFkMunicipio(FkMunicipio fkMunicipio) {
        this.fkMunicipio = fkMunicipio;
    }

    public FkResponsable getFkResponsable() {
        return fkResponsable;
    }

    public void setFkResponsable(FkResponsable fkResponsable) {
        this.fkResponsable = fkResponsable;
    }

    public Integer getCreadopor() {
        return creadopor;
    }

    public void setCreadopor(Integer creadopor) {
        this.creadopor = creadopor;
    }
}

