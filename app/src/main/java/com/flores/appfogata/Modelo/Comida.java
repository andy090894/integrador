package com.flores.appfogata.Modelo;

public class Comida {
    private Integer id;
    private String Nombre;
    private String Precio;
    private String Contenido;
    private String UrlC;

    public Comida(Integer id, String nombre, String precio, String contenido,String urlC) {
        this.id = id;
        Nombre = nombre;
        Precio = precio;
        Contenido = contenido;
        UrlC = urlC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public String getUrlC() {
        return UrlC;
    }

    public void setUrlC(String urlC) {
        UrlC = urlC;
    }
}
