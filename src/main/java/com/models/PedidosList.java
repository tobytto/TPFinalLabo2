package com.models;

import java.util.ArrayList;

public class PedidosList {
    ArrayList<Pedido> pedidosList;

    public PedidosList() {
        this.pedidosList=new ArrayList<>();
    }

    public PedidosList(ArrayList<Pedido> pedidosList) {
        this.pedidosList = pedidosList;
    }

    public  void addPedido(Pedido p){
        p.asignarId(this.maxId());
        this.pedidosList.add(p);
    }

    public int maxId(){
        if (pedidosList.isEmpty()==true){return 0;}
        int maximo = pedidosList.get(0).getId(); // Inicializar con el primer elemento
        for (Pedido generic : pedidosList) {
            if (generic.getId() > maximo) {
                maximo = generic.getId(); // Actualizar el máximo
            }
        }
    return maximo;
    }

    public Pedido ultimoPedidoAgregado() {
        return this.pedidosList.get(pedidosList.size()-1); // Devuelve el último pedido
    }

    public void cambiarEstadoPedido(Pedido p){
        int index = this.pedidosList.indexOf(p);
        p.setEjecutado(true);
        this.pedidosList.set(index,p);
    }

}
