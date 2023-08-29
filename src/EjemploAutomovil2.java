import java.util.Arrays;

public class EjemploAutomovil2 {
    public static void main(String[] args) {

        Automovil2 tsuru = new Automovil2("Tsuru 1998",50000);


        tsuru.setColor("rosita como tu panochita");
        tsuru.setNivelTuneo("Nivel dios");
        tsuru.setSeguridad("baja pero la vida es un riesgo carnal");


        Automovil2 ferrari = new Automovil2();

        ferrari.setModelo("Ferrari 2023");
        ferrari.setPrecio(5000000);
        ferrari.setColor("osea red");
        ferrari.setNivelTuneo("deprimente");
        ferrari.setSeguridad("baja");

        System.out.println(tsuru.detalle());
        System.out.println();
        System.out.println(ferrari.detalle());

        System.out.println();
        System.out.println("Por lo tanto gana el Tsuru, checa nomas ese nivel de tuneo papi");

        //--------------------------------------------------------------------------------------------

        Automovil2 bocho = new Automovil2("boshito bebe leche", 500000);
        bocho.setMotor(new Motor(2.0, TipoMotor.GASOLINA));
        bocho.setEstanque(new Estanque());

        Automovil2 mazda = new Automovil2("Mazdita",40000, "Rojo puta", "medio", new Motor(3.0, TipoMotor.DIESEL) );

        System.out.println(mazda.getMotor().getTipo()+ " " + mazda.detalle());
        //NullPointerException porque tsuru no tiene asignado un tipo motor por lo tanto es nulo y al momonto
        //de querer invocar el metodo nos arroja una excepcion
        //System.out.println(tsuru.getMotor().getTipo());

        //--------------------------------------------------------------------------------------------------
        //vamos a hacer realciones de la clase ruedas y la clase persona

        Persona conductorTsuru = new Persona("Brayan", "El Monas");
        Persona conductorMazda = new Persona("Jose", "Perez");
        tsuru.setPropietario(conductorTsuru);
        mazda.setPropietario(conductorMazda);

        Rueda[] ruedasTsuru = new Rueda[4];
        for (int i = 0; i<ruedasTsuru.length; i++){
            ruedasTsuru[i] = new Rueda("Michelin", 10, 4.5);
        }



        //otra manera
        Rueda[] ruedasMazda = {
                new Rueda("god year", 16, 7.5),
                new Rueda("god year", 16, 7.5),
                new Rueda("god year", 16, 7.5),
                new Rueda("god year", 16, 7.5),
                new Rueda("god year", 16, 7.5)
        };

        //usando el metodo addRueda
        /*Rueda[] ruedasFerrari = new Rueda[5];
        for (int i = 0; i < ruedasFerrari.length; i++){
            ferrari.addRueda(new Rueda("Ferrari", 30, 20));
        }

         */

        //usando el metodo addRueda sin el for

        Rueda[] ruedasFerrari = new Rueda[5];
        ferrari.addRueda(new Rueda("Ferrari", 30, 20)).addRueda(new Rueda("Ferrari", 30, 20)).addRueda(new Rueda("Ferrari", 30, 20)).addRueda(new Rueda("Ferrari", 30, 20)).addRueda(new Rueda("Ferrari", 30, 20));




        tsuru.setRuedas(ruedasTsuru);
        mazda.setRuedas(ruedasMazda);
        //ferrari.setRuedas(ruedasFerrari);

        //asi lo podemos imprimir con un for each
        for (Rueda r: tsuru.getRuedas()) {
            System.out.println(r.getFabricante()+ " " + r.getAro()+ " " + r.getAncho());
        }

        for (Rueda r: ferrari.getRuedas()) {
            System.out.println(r.getFabricante()+ " " + r.getAro()+ " " + r.getAncho());
        }

        //asi se puede imprimir con un for normal
        for (int i = 0; i < ruedasMazda.length; i++) {
            System.out.println(ruedasMazda[i].getFabricante()+ " " + ruedasMazda[i].getAro()+ " " + ruedasMazda[i].getAncho());

        }

        //creamos un arreglo de objetos automovil para poder despues ordenarlos
        Automovil2[] autos = new Automovil2[3];
        autos[0] = mazda;
        autos[1] = ferrari;
        autos[2] = tsuru;

        Arrays.sort(autos); //como implementamos el Comparable en la clase Automovil2 ahora podemos usar este metodo
        for(int i = 0; i<autos.length; i++){
            System.out.println(autos[i].getModelo());
        }
    }
}

