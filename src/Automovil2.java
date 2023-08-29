//añadimos la interfaz comparable para que en nuestra clase ejemplo automovil podamos usar sort para ordenar por marcas
class Automovil2 implements Comparable{
    private Motor motor;
    private Estanque estanque;
    private Persona propietario;
    private Rueda[] ruedas;


    private String modelo;
    private String color;
    private double precio;
    private String seguridad;
    private String nivelTuneo;

    private int indiceRuedas;

    public Automovil2(){
        this.ruedas = new Rueda[5];
    }
    public Automovil2(String modelo, double precio ){
        this();
        this.modelo = modelo;
        this.precio = precio;
    }
    public Automovil2(String modelo, double precio, String color ){
        this(modelo, precio);
        this.color = color;
    }
    public Automovil2(String modelo, double precio, String color, String nivelTuneo ){
        this(modelo, precio, color);
        this.nivelTuneo = nivelTuneo;
    }

    public Automovil2(String modelo, double precio, String color, String nivelTuneo, Motor motor ){
        this(modelo, precio, color, nivelTuneo);
        this.motor = motor;
    }

    public Automovil2(String modelo, double precio, String color, String nivelTuneo, Motor motor, Estanque estanque ){
        this(modelo, precio, color, nivelTuneo,motor);
        this.estanque = estanque;
    }

    public Automovil2(String modelo, double precio, String color, String nivelTuneo, Motor motor, Estanque estanque, Persona persona){
        this(modelo, precio, color, nivelTuneo, motor, estanque);
        this.propietario = persona;
    }

    public Automovil2(String modelo, double precio, String color, String nivelTuneo, Motor motor, Estanque estanque, Persona persona, Rueda[] ruedas){
        this(modelo, precio, color, nivelTuneo, motor, estanque, persona);
        this.ruedas = ruedas;
    }
    public String getModelo(){
        return this.modelo;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public String getNivelTuneo() {
        return nivelTuneo;
    }

    public Estanque getEstanque() {
        //hacemos esto para evitar un NullPointerException en la clase main al llamar al metodo
        if(estanque == null) {
            this.estanque = new Estanque(); //asignamos a la variable estanque la capacidad por defecto con el metodo constructor
        }
        return estanque;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNivelTuneo(String nivelTuneo) {
        this.nivelTuneo = nivelTuneo;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    //creacion de un metodo add para agregar ruedas de una por una
    public Automovil2 addRueda(Rueda rueda){
        this.ruedas[indiceRuedas++] = rueda;
        return this; //con esto hacemos que se invoque su propia referencia por lo tanto
                    //para volver a llamar el metodo solo basta con usar .addRueda("etc")
    }

    public String detalle() {

        StringBuilder sb = new StringBuilder();
        sb.append("modelo = " + this.modelo);
        sb.append("\nprecio = " + this.precio);
        sb.append("\ncolor = " + color);
        sb.append("\nnivelTuneo = " + nivelTuneo);
        sb.append("\nseguridad = " + seguridad);
        return sb.toString();
    }


    @Override
    public int compareTo(Object o) {
        Automovil2 a = (Automovil2) o;
        return this.modelo.compareTo(a.modelo);
    }
}

