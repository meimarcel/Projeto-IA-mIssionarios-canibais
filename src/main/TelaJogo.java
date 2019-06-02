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
import javax.swing.JFrame;
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
    private int i = 0;
    private int posfinal = 100;
    private int posinicial = 600;
    private Timer timer;
    private boolean fim_de_jogo = false;
    private boolean fim = true;
    private List<Estado> caminho;
    private ArrayList<Missionario> missionarios;
    private ArrayList<Canibal> canibais;
    
    
    public Jogo(List<Estado> caminho) {
        setDoubleBuffered(true);
        setFocusable(true);
        this.caminho = caminho;
        this.missionarios = new ArrayList<>();
        this.canibais = new ArrayList<>();
        this.missionarios.add(new Missionario(400,posinicial));
        this.missionarios.add(new Missionario(400,posinicial+100));
        this.missionarios.add(new Missionario(400,posinicial+200));
        this.canibais.add(new Canibal(300,posinicial));
        this.canibais.add(new Canibal(300,posinicial+100));
        this.canibais.add(new Canibal(300,posinicial+200));
        timer = new Timer(1000, this);
        timer.start();

    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D grafico = (Graphics2D) g;
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
        
        if(i<caminho.size()) {
            Estado estado = caminho.get(i);
            for (int l = 0; l < caminho.size(); ++l) {
                if(estado.missionario>l){
                    missionarios.get(l).setPosY(l*100+posfinal);
                }else if(l<=2){
                    missionarios.get(l).setPosY(l*100+posinicial);
                }
                if(estado.canibal>l){
                    canibais.get(l).setPosY(l*100+posfinal);
                }else if(l<=2){
                    canibais.get(l).setPosY(l*100+posinicial);
                }
            }
        i++;
        }
        repaint();
    }
}
