package Puerto;

import java.time.*;

import Avion.Avion;
public class Alquiler {
    Cliente cliente;
    LocalDateTime fechaI;
    LocalDateTime fechaF;
    static int posEstacionamiento = 0;
    Avion avion;

    public Alquiler(Cliente c, LocalDateTime fecha, LocalDateTime fechaF,Avion a){
        this.cliente = c;
        this.fechaI = fecha;
        this.fechaF = fechaF;
        this.avion = a;
        this.posEstacionamiento = posEstacionamiento+1;
    }

    public Alquiler(Cliente c, Avion a){
        this.cliente = c;
        this.fechaI = LocalDateTime.now();
        this.fechaF = null;
        this.avion = a;
        this.posEstacionamiento = posEstacionamiento+1;
    }

    public Alquiler(Cliente c, LocalDateTime fecha,Avion a){
        this.cliente = c;
        this.fechaI = fecha;
        this.fechaF = null;
        this.avion = a;
        this.posEstacionamiento = posEstacionamiento+1;
    }

    public double costoAlquiler(){
        double horas = Duration.between(fechaI, fechaF).toHours();
        double aux = 20*avion.getEnvergadura();

        double res = (horas*aux)+250;
        return res;
    }


    public String toString(){
        String res;

        if(fechaF != null){
            res = "El avion: " + avion + " del cliente " + cliente + " regiestrado el " + fechaI + " hasta el " + fechaF + " se encontraba en: " + posEstacionamiento;
        }else{
            res = "El avion " + avion + " del cliente " + cliente + " regiestrado el " + fechaI + " se encuentra en: " + posEstacionamiento;
        }
        return res;
    }
}
