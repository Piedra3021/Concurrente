package Puerto;

public class Cliente {
    String nombre;
    String apellido;
    int dni;

    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String toString() {
        return  "nombre:'" + nombre + '\'' +
                ", apellido:'" + apellido + '\'' +
                ", dni:" + dni;
    }

}
