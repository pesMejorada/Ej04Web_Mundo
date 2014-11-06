package es.mundo.modelo;

public class Pais {
    private int id;
    private String nombre;
    private int habitantes;
    public Pais(int id, String nombre, int habitantes) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.habitantes = habitantes;
    }
    public Pais(String nombre, int habitantes) {
        super();
        this.nombre = nombre;
        this.habitantes = habitantes;
    }
    public Pais() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHabitantes() {
        return habitantes;
    }
    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
    
   
}
