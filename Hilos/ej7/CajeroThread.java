package ej7;

public class CajeroThread implements Runnable { 
private String nombre; 
private Cliente cliente; 
private long initialTime; 
// Constructor, y métodos de acceso 

public CajeroThread(String n, Cliente c, long t){
    this.nombre = n;
    this.cliente = c;
    this.initialTime = t;
}
 
public void run() { 
System.out.println("El cajero " + this.nombre +  
" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " 
+ this.cliente.getNombre() + " EN EL TIEMPO: " 
+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg"); 
 
for (int i = 0;  i < this.cliente.getCarroCompra().length;  i++) { 
this.esperarXsegundos(cliente.getCarroCompra()[i]); 
System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + "->Tiempo: " + 
     (System.currentTimeMillis() - this.initialTime) / 1000 
+ "seg"); 
} 
 
System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR "+ this.cliente.getNombre() + " EN EL TIEMPO: " + 
     (System.currentTimeMillis() - this.initialTime) / 1000 + 
"seg"); 
} 

public void esperarXsegundos(int t){
    long segundos = t*1000;

    try{
        Thread.sleep(segundos);
    }catch(Exception e){
        System.out.println("Hubo un error realizando la compra");
    }
}
} 
 
