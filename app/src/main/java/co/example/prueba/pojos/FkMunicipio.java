package co.example.prueba.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FkMunicipio {
    @SerializedName("pkMunicipio")
    @Expose
    private Integer pkMunicipio;

    public FkMunicipio(Integer pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    public Integer getPkMunicipio() {
        return pkMunicipio;
    }

    public void setPkMunicipio(Integer pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }
}
