/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ia.BFS;
import ia.Estado;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author meimarcel
 */

public class TelaJogo extends JFrame {
    public TelaJogo(List<Estado> caminho){
        add(new Jogo(caminho));
        setVisible(true);
        setTitle("Canibais e Missionarios");
        setSize(1000,840);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
    
}
class Jogo extends JPanel implements ActionListener {
    private int i = 0,j=0;
    private int posfinal = 20;
    private int posinicial = 800;
    private Canoa canoa;
    private Timer timer;
    private boolean fim_de_jogo = false;
    private boolean fim = true;
    private List<Estado> caminho;
    private ArrayList<Missionario> missionarios;
    private ArrayList<Canibal> canibais;
    private Image fundoIMG;
    private Estado anterior = new Estado(0,0,false);
    
    
    public Jogo(List<Estado> caminho) {
        setDoubleBuffered(true);
        setFocusable(true);
        this.caminho = caminho;
        this.missionarios = new ArrayList<>();
        this.canibais = new ArrayList<>();
        this.canoa = new Canoa(600,posinicial-300);
        this.missionarios.add(new Missionario(450,posinicial));
        this.missionarios.add(new Missionario(450,posinicial+40));
        this.missionarios.add(new Missionario(450,posinicial+80));
        this.canibais.add(new Canibal(500,posinicial));
        this.canibais.add(new Canibal(500,posinicial+40));
        this.canibais.add(new Canibal(500,posinicial+80));
        ImageIcon ref = new ImageIcon("src//img//fundo.jpg");
        fundoIMG = ref.getImage();
        timer = new Timer(100, this);
        timer.start();
        
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D grafico = (Graphics2D) g;
        grafico.drawImage(fundoIMG, 0, 0, 1000, 840, this);
        grafico.drawImage(canoa.getImage(), canoa.getPosY(), canoa.getPosX(), this);
        grafico.drawImage(missionarios.get(0).getImage(), missionarios.get(0).getPosY(), missionarios.get(0).getPosX(), this);
        grafico.drawImage(missionarios.get(1).getImage(), missionarios.get(1).getPosY(), missionarios.get(1).getPosX(), this);
        grafico.drawImage(missionarios.get(2).getImage(), missionarios.get(2).getPosY(), missionarios.get(2).getPosX(), this);
        grafico.drawImage(canibais.get(0).getImage(), canibais.get(0).getPosY(), canibais.get(0).getPosX(), this);
        grafico.drawImage(canibais.get(1).getImage(), canibais.get(1).getPosY(), canibais.get(1).getPosX(), this);
        grafico.drawImage(canibais.get(2).getImage(), canibais.get(2).getPosY(), canibais.get(2).getPosX(), this);
        
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Estado estado = caminho.get(i);
        if(j<25){
            if(estado.canoa){
                this.canoa.setPosY(this.canoa.getPosY()-10); 
                for (int k = anterior.missionario; k < estado.missionario; k++) {
                    missionarios.get(k).setPosY(this.canoa.getPosY()+(50*k));
                }
                for (int k = anterior.canibal; k < estado.canibal; k++) {
                    canibais.get(k).setPosY(this.canoa.getPosY()+(50*k));
                }
            }
            else{
                this.canoa.setPosY(this.canoa.getPosY()+10);
                for (int k = estado.missionario; k < anterior.missionario; k++) {
                    missionarios.get(k).setPosY(this.canoa.getPosY()+(50*k));
                }
                for (int k = estado.canibal; k < anterior.canibal; k++) {
                    canibais.get(k).setPosY(this.canoa.getPosY()+(50*k));
                }
            }
            j++;
        }else{
            if(i<caminho.size()) {
                for (int l = 0; l < 3; ++l) {
                    if(estado.missionario>l){
                        missionarios.get(l).setPosY(l*40+posfinal);
                    }else if(l<=2){
                        missionarios.get(l).setPosY(l*40+posinicial);
                    }
                    if(estado.canibal>l){
                        canibais.get(l).setPosY(l*40+posfinal);
                    }else if(l<=2){
                        canibais.get(l).setPosY(l*40+posinicial);
                    }
                }
                anterior = caminho.get(i);
                if(i+1==caminho.size()){
                    
                    i=i;
                    j= 20;
                    timer.stop();
                }else{
                    i++;
                }
            }
         j=0;   
        }
        repaint();
    }

}
