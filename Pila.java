/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.torrehanoi;

/**
 *
 * @author suyan
 */
public class Pila {
    private int ContNodo=0;
    private Nodo Cabeza;
    public int getContNodo() {
        return ContNodo;
    }

    public void setContNodo(int ContNodo) {
        this.ContNodo = ContNodo;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo Cabeza) {
        this.Cabeza = Cabeza;
    }
    
    public void Push(Nodo N){
        ContNodo++;
        if(Cabeza==null){
            Cabeza=N;
        }else{
            N.setAbajo(Cabeza);
            Cabeza.setArriba(N);
            Cabeza=N;
        }
    }
    public void Pop(){
        if(ContNodo>0){
            ContNodo--;
            Cabeza=Cabeza.getAbajo();
        }
    }
    public String Peek(){
        return Cabeza.getDato();
    }
}
