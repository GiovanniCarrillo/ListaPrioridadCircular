public class ListaCircular extends ListaSimple {

    public ListaCircular() {
        super();
    }

    @Override
    public boolean insertar(char dato, int nivel) {
        boolean resp = super.insertar(dato, nivel); 
        if (!resp) {
            return false;
        }
        fin.setSig(ini);//FIN apunta a INI = Circular 
        return true;
    }

    
    @Override
    public boolean eliminar() {
        if (!estaVacia()) fin.setSig(null);
        boolean resp = super.eliminar();
        if (!resp) return false;
        if (!estaVacia()) fin.setSig(ini);
        return true;
    }

}