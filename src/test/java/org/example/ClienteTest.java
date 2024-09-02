package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Loja loja = new Loja("Loja de Eletrônicos", "Av Rio Branco, 100");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.inscrever(loja);
        loja.lancarNovoProduto();
        assertEquals("Cliente 1, novo produto lançado na Loja{nome='Loja de Eletrônicos', endereco='Av Rio Branco, 100'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Loja loja = new Loja("Loja de Eletrônicos", "Av Rio Branco, 100");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.inscrever(loja);
        cliente2.inscrever(loja);
        loja.lancarNovoProduto();
        assertEquals("Cliente 1, novo produto lançado na Loja{nome='Loja de Eletrônicos', endereco='Av Rio Branco, 100'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, novo produto lançado na Loja{nome='Loja de Eletrônicos', endereco='Av Rio Branco, 100'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Loja loja = new Loja("Loja de Eletrônicos", "Av Rio Branco, 100");
        Cliente cliente = new Cliente("Cliente 1");
        loja.lancarNovoProduto();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteLojaA() {
        Loja lojaA = new Loja("Loja de Eletrônicos A", "Av Rio Branco, 100");
        Loja lojaB = new Loja("Loja de Eletrônicos B", "Av Brasil, 200");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.inscrever(lojaA);
        cliente2.inscrever(lojaB);
        lojaA.lancarNovoProduto();
        assertEquals("Cliente 1, novo produto lançado na Loja{nome='Loja de Eletrônicos A', endereco='Av Rio Branco, 100'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
