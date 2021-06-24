package Entidades;

public class Generos {

    private String name;

    private int cantidad = 0;

    public Generos(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void addCantidad() {
        this.cantidad++;
    }

    public boolean equals(Object obj) {
        boolean equalsToReturn = false;

        equalsToReturn = ((Generos) obj).getName().equals(this.name);

        return equalsToReturn;
    }


}
