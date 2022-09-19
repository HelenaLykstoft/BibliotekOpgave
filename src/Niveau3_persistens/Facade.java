package Niveau3_persistens;

public class Facade {
  static Minliste minliste = new Minliste();
    public static void insert(){
        //Mapper.insert();
        minliste.insert();
    }

    public static void slet(){
        //Mapper.slet();
        minliste.slet();
    }

    public static void udskrivNavne(){
        //Mapper.udskrivNavne();
        minliste.udskrivNavne();
    }

    public static void updaterNavne(){
        Mapper.updaterNavne();
    }
}
