package ej7;

public class Cliente extends Thread { 
private String nombre; 
private int[] carroCompra; 
// Constructor y métodos de acceso 

public Cliente(String nombre, int[] carrito){
    this.nombre = nombre;
    this.carroCompra = carrito;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int[] getCarroCompra() {
    return carroCompra;
}

public void setCarroCompra(int[] carroCompra) {
    this.carroCompra = carroCompra;
}


} 


