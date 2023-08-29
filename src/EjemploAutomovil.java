import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {

        //creando nuestro primer objeto de la clase automovil
        //Automovil tsuru = new Automovil();
        Automovil tsuru = new Automovil("Tsuru 1998",50000);
/*
        tsuru.seguridad = "baja";
        tsuru.nivelTuneo = "nivel dios";
        tsuru.color = "rosita";
        tsuru.modelo = "tsuru 1998";
        tsuru.precio = 50000;
*/


        //tsuru.setModelo("Tsuru 1998");
        tsuru.setColor("rosita como tu panochita");
        //tsuru.setPrecio(50000);
        tsuru.setNivelTuneo("Nivel dios");
        tsuru.setSeguridad("baja pero la vida es un riesgo carnal");

        //creando un segundo objeto de la clase automovil
        Automovil ferrari = new Automovil();

/*
        ferrari.seguridad = "baja";
        ferrari.color = "red";
        ferrari.modelo = "Ferrari 2023";
        ferrari.nivelTuneo = "Deprimente";
        ferrari.precio = 5000000;
*/
        ferrari.setModelo("Ferrari 2023");
        ferrari.setPrecio(5000000);
        ferrari.setColor("osea red");
        ferrari.setNivelTuneo("deprimente");
        ferrari.setSeguridad("baja");

        //el crear metodos fuera de la clase main para despues llamarlos desde esta se conoce como encapsulamiento
        System.out.println(tsuru.detalle());
        System.out.println();
        System.out.println(ferrari.detalle());

        System.out.println(ferrari.acelerar(3000));
        System.out.println(tsuru.frenar());

        System.out.println();
        System.out.println("Por lo tanto gana el Tsuru, checa nomas ese nivel de tuneo papi");

        System.out.println(tsuru.acelerarFrenar(50));
        System.out.println("Kilometros por litro: " +tsuru.calcularConsumo(300, 0.6f));
        System.out.println("Kilometros por litro: " +tsuru.calcularConsumo(300, 60));
        System.out.println(tsuru.getNivelTuneo());

        //------------------------------------------------------------------------------------------------
        //vamos a comprobar si dos objetos son iguales

        Automovil nissan = new Automovil("nissan tida",150000, "azul", "poderoso" );
        Automovil nissan2 = new Automovil("nissan tida",150000, "azul", "poderoso" );
        System.out.println("son iguales? " +(nissan==nissan2));
        System.out.println("son iguales? " +(nissan.equals(nissan2)));

        //vamos a comparar dos objetos de clases distinatas

        Date fecha = new Date();
        //System.out.println(nissan.equals(fecha)); // esto da error son dos tipos incompatibles

        //--------------------------------------------------------------------------------------------
        //uso de static cuando usamos static quiere decir que es un elemento compartido de la clase
        //se tiene que llamar con el nombre de la clase por ejemplo "Automovil.metodo o variable"
        //Automovil.colorPatente = "cafe";
        Automovil.setColorPatente("caquita");
        System.out.println("color patente: " + Automovil.getColorPatente());

        System.out.println("id tsuru: " + tsuru.getId());
        System.out.println("id ferrari: " + ferrari.getId());
        System.out.println("id nissan: " + nissan.getId());
        System.out.println("id nissan2: " + nissan2.getId());

        //uso constantes con final
        System.out.println("cual es el lim de velocidad? " + Automovil.LIMITE_VELOCIDAD+ " km/hr");

        //ahora si uso de enum
        tsuru.setBocinas(Bocinas.BRAYANINC);
        ferrari.setBocinas(Bocinas.SONY);
        nissan.setBocinas(Bocinas.PANASONIC);
        nissan2.setBocinas(Bocinas.HECHIZA);

        System.out.println("tsuru = " + tsuru.getBocinas().getBocina());
        System.out.println("ferrari = " + ferrari.getBocinas().getBocina());
        System.out.println("nissan = " + nissan.getBocinas().getBocina());
        //Asi y sin el metodo toString en la clase enum solo se imprimira el nombre del enumerador
        System.out.println("nissan2 = " + nissan2.getBocinas());

        //Uso de enum para la clase TipoAutomovil
        tsuru.setTipo(TipoAutomovil.CONVERTIBLE);
        nissan.setTipo(TipoAutomovil.MATHBACK);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        ferrari.setTipo(TipoAutomovil.FURGON);

        System.out.println("tsuru.getTipo() = " + tsuru.getTipo().getDescripcion());
        System.out.println("nissan = " + nissan.getTipo().getDescripcion());
        System.out.println("ferrari = " + ferrari.getTipo().getPuertas());
        System.out.println("nissan2 = " + nissan2.getTipo().getNombre());

    }
}

//cuando el archivo lleva otro nombre la clase no puede ser publica solo default
// esto aplica en todas las clases que creemos en conjunto de la clase main
// si por el contrario creamos las clases en archivos separados si pueden llevar el modificador
//public ya que la clase se llamara igual que el archivo
class Automovil{

    //hacer privadas las variables para que no se pueda acceder a ellas directamente es el principio de ocultacion
    private String modelo;
    private String color;
    private double precio;
    private String seguridad;
    private String nivelTuneo;
    private int capacidadTanque = 40;

    private static String colorPatente = "Naranja"; //creacion de atributo estatico

    //uso de metodos estaticos nos puede servir para ir incrementando de forma automatica el identificador
    //de cada objeto automovil que creemos

    private int id;
    private static int ultimoId;

    //uso de final
    public final static Integer LIMITE_VELOCIDAD = 100;

    private Bocinas bocinas;
    private TipoAutomovil tipo;

    //creacion de metodo constructor
    public Automovil(){
        this.id =++ultimoId;
    }
    public Automovil(String modelo, double precio ){
        this(); // para que use el constructor vacio y asi incremente el id
        this.modelo = modelo;
        this.precio = precio;
    }
    //sobrecarga de metodos podemos tener mas de un metodo constructor

    public Automovil(String modelo, double precio, String color ){
        this(modelo, precio);
        this.color = color;
    }
    public Automovil(String modelo, double precio, String color, String nivelTuneo ){
        this(modelo, precio, color); //llamamos a otro metodo constructor para que le de los atibutos
        this.nivelTuneo = nivelTuneo; // y en este metodo constructor agregamos otro parametro
    }

    //metodos getter y setter
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

    public int getCapacidadTanque() {
        return capacidadTanque;
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

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    //solo estamos creando los metodos setter y getter para poder mostrar y hacer uso de la clase enum despues
    public void setBocinas(Bocinas bocinas){
        this.bocinas = bocinas;
    }
    public Bocinas getBocinas(){
        return bocinas;
    }

    //creando setter y getter para clase enum TipoAutomovil
    public void setTipo(TipoAutomovil tipo){
        this.tipo = tipo;
    }
    public TipoAutomovil getTipo(){
        return tipo;
    }


    public String detalle() {
        //usamos this para indicar que queremos acceder a un atributo dentro de un metodo de la misma clase
        String modelo = "otro"; // con el this evitamos que se imprima modelo = otro ya que con this hacemos referencia al atributo de la clase

        //ya que no es recomendable que una clase imprima coasas usamos la clase StringBulder para crear un
        //objeto con el cual a travez del metodo append concatenar las cadenas de texto para al final retornar un String
        StringBuilder sb = new StringBuilder();
        sb.append("modelo = " + this.modelo);
        sb.append("\nprecio = " + this.precio);
        sb.append("\ncolor = " + color);
        sb.append("\nnivelTuneo = " + nivelTuneo);
        sb.append("\nseguridad = " + seguridad);
        sb.append("\ncolor de patente " + Automovil.colorPatente); //asi se llama a una variable estatica
        return sb.toString();
    }

    public String acelerar(int rpm) {
        return "el auto " + modelo + " acelerando a " + rpm + " revoluciones por minuto";
    }
    public String frenar(){
        return modelo+ " " + "frenado";
    }
    public String acelerarFrenar(int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }
    public float calcularConsumo(int km, float porcentajeGasolina){
        return km/(capacidadTanque+porcentajeGasolina);
    }
    //sobrecarga de metodos de clase
    public float calcularConsumo(int km, int porcentajeGasolina){
        return km/(capacidadTanque+(porcentajeGasolina)/100f);
    }

    //sobreescritura de metodo equals
    @Override
    public boolean equals(Object obj){
        Automovil a = (Automovil) obj; //se hace un cast porque vamos a comparar dos objetos de tipo automivil
        //se compara que sean iguales ciertas propiedades del objeto y que estos no sean nulos
        //para que no se lance una exception
        return ( this.modelo != null && this.color != null &&
                this.modelo.equals(a.getModelo()) && this.color.equals(a.getColor()));
    }
    //metodos estaticos setter and getter
    public static String getColorPatente(){
        return colorPatente;
    }
    public static void setColorPatente(String colorPatente){
         Automovil.colorPatente = colorPatente;
    }

    public int getId(){
        return id;
    }
}

//asi se crea una clase enum, sirve para fijar caracteristicas constantes
enum Bocinas{
    SONY("Sony rtx2900S"),
    PANASONIC("Panasonic B30x"),
    HECHIZA("Hechiza Garrafa de gasolina agujereada"),
    BRAYANINC("BrayanInc se la robe a mi primo homs");

    private final String bocina;
    Bocinas(String bocina){
        this.bocina = bocina;
    }

    public String getBocina(){
        return bocina;
    }


//al hacer esto queda mas optimizado el codigo ya que no sera necesario en la clase main pasar
// los dos metodos getter nissan.getBocinas().getBocina() para obtener el nombre de la bocina
// bastara con nissan.getBocinas()
/*
    @Override
    public String toString() {
        return this.bocina;
    }

 */
}
