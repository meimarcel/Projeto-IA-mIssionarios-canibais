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
public class Estado {
    public int canibal;
    public int missionario;
    public boolean canoa;
    public Estado pai;
    
    public Estado(int canibal, int missionario, boolean canoa) {
        this.canibal = canibal;
        this.missionario = missionario;
        this.canoa = canoa;
    }
    
}


