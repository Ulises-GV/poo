import java.util.Date;

public class EjemploAutomovilEnum {
    public static void main(String[] args) {

        Automovil tsuru = new Automovil("Tsuru 1998",50000);


        tsuru.setColor("rosita como tu panochita");
        tsuru.setNivelTuneo("Nivel dios");
        tsuru.setSeguridad("baja pero la vida es un riesgo carnal");


        Automovil ferrari = new Automovil();

        ferrari.setModelo("Ferrari 2023");
        ferrari.setPrecio(5000000);
        ferrari.setColor("osea red");
        ferrari.setNivelTuneo("deprimente");
        ferrari.setSeguridad("baja");

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


        //------------------------------------------------------------------------------------------
        //uso de la clase enum junto con switch case

        tsuru.setTipo(TipoAutomovil.FURGON);
        ferrari.setTipo(TipoAutomovil.CONVERTIBLE);

        TipoAutomovil tipo = tsuru.getTipo();
        System.out.println("tsuru = " + tipo.getNombre());
        System.out.println("tipo = " + tipo.getDescripcion());

        tipo = tsuru.getTipo();
        switch(tipo){
            //version mejorada de switch case no necesita el break pero solo funciona en jdk 13 3n adelante
            //case SEDAN -> System.out.println("ja ja ja ando bien grifindor");
            case SEDAN:
                System.out.println("A nu ma wey es un piche carro godin");
                break;
            case FURGON:
                System.out.println("El mejor lugar para hacer el amor 100% real no fake");
                break;
            case PICKUP:
                System.out.println("pa la guerra y las armas y los levantones tambien pa levantar morritas");
                break;
            case CONVERTIBLE:
                System.out.println("pinche carro fifi puro pinche joto lo usa y morrita fresa panocha rosita");
                break;
            case MATHBACK:
                System.out.println("ya tira esa madre we");
                break;
            case STATION_WAGON:
                System.out.println("La neta no se ni que verga sea carnal ha de ser carro de señora");
                break;
        }
    }
}

