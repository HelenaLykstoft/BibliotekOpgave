package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

import java.util.LinkedList;
import java.util.List;

public class Minliste {
    List<String> list = new LinkedList<>();

    public Minliste() {
       list.add("palle");
       list.add("ulla");
       list.add("bæn9");
       list.add("lone");
    }

    protected void insert(){
        list.add(TerminalInput.getString("Skriv et navn"));
    }

    protected void slet(){
        list.remove(TerminalInput.getString("skriv navnet på den kunde der skal slettes "));
    }

    protected void udskrivNavne(){
        for (String s : list) {
            System.out.println(s);
        }
    }
}
