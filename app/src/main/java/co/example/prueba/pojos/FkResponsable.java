package co.example.prueba.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FkResponsable {

    @SerializedName("pkPersona")
    @Expose
    private Integer pkPersona;

    public Integer getPkPersona() {
        return pkPersona;
    }

    public void setPkPersona(Integer pkPersona) {
        this.pkPersona = pkPersona;
    }

    public FkResponsable(Integer pkPersona) {
        this.pkPersona = pkPersona;
    }
}
