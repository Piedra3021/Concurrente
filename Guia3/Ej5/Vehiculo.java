package Guia3.Ej5;

public class Vehiculo {
    
    private String patente;
    private String modelo;
    private String marca;
    private Double km = 0.0;

    public Vehiculo(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    
}
