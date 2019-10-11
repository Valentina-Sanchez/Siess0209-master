package co.example.prueba.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FkFicha {

    @SerializedName("pkFicha")
    @Expose
    private Integer pkFicha;

    public Integer getPkFicha() {
        return pkFicha;
    }

    public void setPkFicha(Integer pkFicha) {
        this.pkFicha = pkFicha;
    }

    public FkFicha(Integer pkFicha) {
        this.pkFicha = pkFicha;
    }
}
