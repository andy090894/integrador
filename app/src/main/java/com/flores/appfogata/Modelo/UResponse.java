package com.flores.appfogata.Modelo;

import com.flores.appfogata.Modelo.Comida;

import java.util.ArrayList;
import java.util.List;

public class UResponse {
    private Integer estado;
    private List<Comida> comidas = new ArrayList<Comida>();

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }
}
