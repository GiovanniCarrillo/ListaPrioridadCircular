public class ListaSimple {
    protected Nodo ini;
    protected Nodo fin;
    
    public ListaSimple(){
        ini = fin = null;
    }
    
    public boolean insertar(char dato, int nivel){
        Nodo nuevo = new Nodo(dato, nivel);//Se crea un nuevo nodo
        if(nuevo==null) return false;
        if(estaVacia()){//Si esta vacia
            ini = fin = nuevo;//INI Y FIN SE POSICIONAN EN EL NODO INSERTADO
            return true;
        }
        if(existe(nuevo)) return false;
        if(nuevo.getNivel() <= fin.getNivel()){ //EL NODO NUEVO TIENE UN NIVEL INFERIOR O IGUAL A EL ULTIMO VALOR
            fin.setSig(nuevo);//FIN APUNTA A EL NODO NUEVO 
            fin = nuevo;//FIN SE POSICIONA EN EL NODO NUEVO
            return true;
        }
        
        if(nuevo.getNivel() > ini.getNivel()){//EL NUEVO NODO TIENE UN NIVEL SUPERIOR AL PRIMER NODO DE LA LISTA
            nuevo.setSig(ini); //EL NODO NUEVO APUNTA A EL PRIMER NODO DE LA LISTA
            ini = nuevo; //INI SE POSICIONA EN EL NODO NUEVO
            return true;       
        }
        Nodo t2 = ini; 
        Nodo t1 = ini.getSig();
        do {//SE REALIZA EL INTERCAMBIO 
            if(nuevo.getNivel()<= t1.getNivel()){//Si el nivel del nodo nuevo es inferior al nivel de t1  
                t1 = t1.getSig();//t1 avanza a el siguiente nodo
            }else{//EL NIVEL DEL NUEVO NODO ES SUPERIOR A EL NIVEL DE T1
                t2.setSig(nuevo);//t2 apunta a nuevo  (t2)---> (nuevo)
                nuevo.setSig(t1);//nuevo apunta a t1 nuevo-->(t1)
                return true; // (t2)---> (nuevo)--->(t1) Entonces el nuevo nodo queda insertado. 
            }
                t2 = t2.getSig();// t2 avanza a el siguiente nodo
        } while (t2 != null);

        return false;
       
    }
    
    
    public boolean eliminar(){
        if(estaVacia()) return false;
        if(hayUnNodo()){
            ini = fin = null;
            return true;
        }
        Nodo temp = ini;
        ini = temp.getSig();
        temp.setSig(null);
        temp = null; //BORRADO FÍSICO
        return true; 
    }
    protected boolean estaVacia(){
        return ini==null && fin== null;
    }
    
    protected boolean hayUnNodo(){
        return ini == fin;
    }
    public Nodo getIni(){
        return ini;
    }
    
    protected int contarNodo(){
        if(estaVacia())return 0; 
        int contador = 1;
        for(Nodo temp = ini; temp!=fin; temp = temp.getSig()){
            contador++;
        }        
        return contador;
    }
    
    public boolean existe(Nodo nuevo){
        Nodo temp = ini;
        do{
            if(nuevo.getDato() == temp.getDato()){
                return true;
            }
            temp = temp.getSig();
        }while(temp != ini);
        return false;
    }
    
}
