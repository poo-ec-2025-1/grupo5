package model;

import java.util.ArrayList;
import java.util.List;

public class SessaoCompra {
    private static SessaoCompra instancia;
    private List<Planta> carrinho;
    private double total;

    private SessaoCompra() {
        carrinho = new ArrayList<>();
    }

    public static SessaoCompra getInstancia() {
        if (instancia == null) {
            instancia = new SessaoCompra();
        }
        return instancia;
    }

        public void setCarrinho(List<Planta> carrinho) {
    this.carrinho = new ArrayList<>(carrinho); // Cópia mutável
    calcularTotal();
    }


    public List<Planta> getCarrinho() {
        return carrinho;
    }

    public double getTotal() {
        return total;
    }

    private void calcularTotal() {
        total = carrinho.stream().mapToDouble(Planta::getPreco).sum();
    }

    public void limpar() {
        carrinho.clear();
        total = 0.0;
    }
}

