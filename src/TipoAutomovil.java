
//clase enumerador con mas de una caracteristca
public enum TipoAutomovil {
    SEDAN("Sedan", "Auto normal", 4),
    STATION_WAGON("Station wagon", "auto grande", 5),
    MATHBACK("Haschback", "Auto compacto", 4),
    PICKUP("Pick Up", "Camioneta", 2),
    FURGON("Furgoneta", "Combi", 3),
    CONVERTIBLE("Convertible", "Auto deportivo", 2);

    private final String nombre;
    private final String descripcion;
    private final int puertas;

    TipoAutomovil(String nombre, String descripcion, int puertas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puertas = puertas;
    }

    public String getNombre(){
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getPuertas() {
        return puertas;
    }
}
