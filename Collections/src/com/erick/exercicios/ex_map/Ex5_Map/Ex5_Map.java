package com.erick.exercicios.ex_map.Ex5_Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;


public class Ex5_Map {
    public static void main(String[] args) {
        Map<Integer, Contato> contatos = new HashMap<Integer, Contato>(){{
            put(3, new Contato("Kimberly", 3333));
            put(1, new Contato("Erick", 5555));
            put(4, new Contato("Cristiano", 7777));
            put(2, new Contato("Gislaine", 4444));
        }};

        System.out.println("Contatos: Ordem Aleatoria ");
        for (Map.Entry<Integer, Contato> contato : contatos.entrySet()) {
            System.out.println("Nome: " + contato.getValue().getNome() + " - ID: "+ contato.getKey() + " - Numero: " + contato.getValue().getNumero());
        }
        System.out.println();


        Map<Integer, Contato> contatos2 = new LinkedHashMap<Integer, Contato>(){{
            put(3, new Contato("Kimberly", 3333));
            put(1, new Contato("Erick", 5555));
            put(4, new Contato("Cristiano", 7777));
            put(2, new Contato("Gislaine", 4444));
        }};

        System.out.println("Contatos: Ordem de Insercao ");
        for (Map.Entry<Integer, Contato> contato : contatos2.entrySet()) {
            System.out.println("ID: "+ contato.getKey() + " - Nome: " + contato.getValue().getNome() + " - Numero: " + contato.getValue().getNumero());
        }
        System.out.println();


        Map<Integer, Contato> contatos3 = new TreeMap<>();
        contatos3.putAll(contatos);
        System.out.println("Contatos: Ordem de ID ");
        for (Map.Entry<Integer, Contato> contato : contatos3.entrySet()) {
            System.out.println("ID: "+ contato.getKey() + " - Nome: " + contato.getValue().getNome() + " - Numero: " + contato.getValue().getNumero());
        }
        System.out.println();


        TreeSet<Map.Entry<Integer, Contato>> contatos4 = new TreeSet<Map.Entry<Integer, Contato>>(new ComparatorNumero());
        contatos4.addAll(contatos.entrySet());

        System.out.println("Contatos: Ordem de Numero ");
        for (Entry<Integer,Contato> contato : contatos4) {
            System.out.println("Numero: " + contato.getValue().getNumero() + " - Nome: " + contato.getValue().getNome() + " - ID: " + contato.getKey());
        }
        System.out.println();


        Set<Map.Entry<Integer, Contato>> contatos5 = new TreeSet<Map.Entry<Integer, Contato>>(new ComparatorNome());
        contatos5.addAll(contatos.entrySet());

        System.out.println("Contatos: Ordem Nome ");
        for (Entry<Integer,Contato> contato : contatos5) {
            System.out.println("Nome: " + contato.getValue().getNome() + " - ID: "+ contato.getKey() + " - Numero: " + contato.getValue().getNumero());
        }
        System.out.println();




    }
}

class ComparatorNumero implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {

        return o1.getValue().getNumero().compareTo(o2.getValue().getNumero());
    }

}

class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
        Integer nome = o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
        if(nome!=0) return nome;

        return o1.getKey().compareTo(o2.getKey()) ;
    }

}
