
public class Pila {

    private Nodo cabeza;
    private int tamaño;

    public Nodo getCabeza() {
        return cabeza;
    }
    
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Pila() {
        cabeza = null;
        tamaño = 0;
    }

    public void apilar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }
        tamaño++;
    }

    public int desapilar() {
        int valor = cabeza.getNumero();
        cabeza = cabeza.getSiguiente();
        tamaño--;
        return valor;
    }

    public int getTamaño() {
        return tamaño;
    }

    public String mostrarPila(){
        String  pilaInfo = "";
        Nodo auxiliar = cabeza;
        while(auxiliar != null){
            pilaInfo += auxiliar.getNumero() + "\n";
            auxiliar = auxiliar.getSiguiente();
        }
        return pilaInfo;
    }
    
    public boolean esSombrero(Pila pila) {
    
        Nodo auxiliar1 = cabeza;
        Nodo auxiliar2 = pila.cabeza;

        while (auxiliar1 != null) {

            if (auxiliar2.getSiguiente() == null) {
                break;
            }

            if (auxiliar1.getNumero() != auxiliar2 .getNumero()) {
                return false;
            }

            auxiliar1 = auxiliar1 .getSiguiente();
            auxiliar2 = auxiliar2 .getSiguiente();
        }
        return true;
    }

    public int verficarBase(){
        
        Nodo auxiliar = cabeza;

        while(auxiliar.getSiguiente() != null){
            auxiliar = auxiliar.getSiguiente();
        }
        
        if(auxiliar.getNumero() < getTamaño() ){
            return -1;
        
        } else if( auxiliar.getNumero() > getTamaño() ){
            return 1;
        } 
        
        return 0;
        
    } 
}
