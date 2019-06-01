/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia;

/**
 *
 * @author meimarcel
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
//    int[] canibais = {1,2,0,0,1};
//    int[] missionarios = {0,0,1,2,1};

    int[] canibais = {1,0,0,2,1};
    int[] missionarios = {1,2,1,0,0};
    
    boolean[] canoa = {true, false};
    Queue<Estado> fronteira = new LinkedList<>(); 
    
    public BFS() {   
    }
    
    public List<Estado> search(Estado inicial) {
        List<Estado> caminho = new ArrayList<>();
        Estado atual = inicial;
        atual.pai = null;
        this.fronteira.add(atual);
        
        while(!this.fronteira.isEmpty()) {
            atual = this.fronteira.poll();
            if(atual.canoa == false) {
                
                for(int i = 0; i < 5; ++i) {
                    Estado aux = new Estado((atual.canibal + canibais[i]),
                            (atual.missionario + missionarios[i]),
                            this.canoa[0]);
                    aux.pai = atual;
                    if((aux.canibal == aux.missionario) || (aux.missionario == 3 || aux.missionario == 0)) {
                        if(aux.canibal <= 3 && aux.missionario <= 3){
                            this.fronteira.add(aux);
                            caminho.add(aux);
                            if(aux.canibal == 3 && aux.missionario == 3) {
                                return caminho;
                            }
                        }
                    }

                }
                
            } else {
                
                 for(int i = 0; i < 5; ++i) {
                    Estado aux = new Estado((atual.canibal - canibais[i]),
                            (atual.missionario - missionarios[i]),
                            this.canoa[1]);
                    aux.pai = atual;
                    if((aux.missionario == 0 || aux.missionario == 3) || (aux.canibal == aux.missionario)) {
                        if(aux.missionario >= 0 && aux.canibal >= 0) {
                            this.fronteira.add(aux);
                            caminho.add(aux);
                        }
                    }

                }
                
            }
        }
        
        return caminho;
        
    }
    
}
