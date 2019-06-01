/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author meimarcel
 */
import ia.BFS;
import ia.Estado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        BFS BFS = new BFS();
        Estado inicial = new Estado(0,0,false);
        List<Estado> grafo = BFS.search(inicial);
        
        Estado atual = grafo.get(grafo.size() - 1);
        List<Estado> caminho = new ArrayList<>();
        
        while(atual.pai != null) {
            caminho.add(atual);
            atual = atual.pai;
        }
        
        Collections.reverse(caminho);
        
        for(Estado e : caminho) {
            System.out.println(e.canibal+","+e.missionario+","+e.canoa);
        }
        
        
    }
    
}
