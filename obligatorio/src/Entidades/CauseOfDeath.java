package Entidades;

public class CauseOfDeath {

    private String name;

    private int victimas = 0;

    public CauseOfDeath(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVictimas() {
        return victimas;
    }

    public void addVictimas() {
        this.victimas ++;
    }

    public boolean equals(Object obj) {
        boolean equalsToReturn = false;

        equalsToReturn = ((CauseOfDeath) obj).getName().equals(this.name);

        return equalsToReturn;
    }
}
