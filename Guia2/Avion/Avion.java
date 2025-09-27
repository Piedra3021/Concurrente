package Guia2.Avion;

public class Avion {
    String matricula;
    double envergadura;
    int anio;

    public Avion(String m,double e, int a){
        this.matricula = m;
        this.envergadura = e;
        this.anio = a;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String toString(){
        return "Matricula: " + matricula + " envergadura: " + envergadura + " del año: " + anio;
    }
}
