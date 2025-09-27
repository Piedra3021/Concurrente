package Hilos;

public class testeoHilos {
    public static void main (String[] args){ 
Thread miHilo=  new MiEjecucion();    
miHilo.start(); 
/*try{
miHilo.join();
} catch(Exception e){
    System.out.println("error");
}*/
try{
    Thread.sleep(1000);
}catch(Exception e){
    System.out.println("En el main");
}

System.out.println("En el main");       
} 
}
