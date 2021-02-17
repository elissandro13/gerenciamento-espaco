/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentoterra;

import gerenciamentoterra.entidades.PlanetaTerra;
import java.util.Scanner;


public class GerenciamentoEspacoTerra {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***SISTEMA DE GERENCIAMENTO DO ESPAÇO DA TERRA***");

        System.out.println("Informe a quantidade de continentes do planeta terra: ");
        int quantidadeContinentes = scanner.nextInt();

        PlanetaTerra planetaTerra = new PlanetaTerra(quantidadeContinentes);

        System.out.println("Digite a opção desejada: "
                + "\n 1-Geranciar Continentes "
                + "\n 2-Gerenciar Estados"
                + "\n 3-Gerenciar Países"
                + "\n 4-Gerenciar Municícpios"
                + "\n 5-Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1: {
                GerenciamentoContinente gerenciamentoContinente = new GerenciamentoContinente();
                gerenciamentoContinente.gerenciarContinente(planetaTerra);
                break;
            }
            case 2: {
                GerenciamentoEstado gerenciamentoEstado = new GerenciamentoEstado();
                gerenciamentoEstado.gerenciarEstado(planetaTerra);
                
                break;
            }
            case 3: {
                GerenciamentoPais gerenciamentoPais = new GerenciamentoPais();
                gerenciamentoPais.gerenciarPais(planetaTerra);
                break;
            }
            case 4: {
                GerenciamentoMunicipio gerenciamentoMunicipio = new GerenciamentoMunicipio();
                gerenciamentoMunicipio.gerenciarMunicipio(planetaTerra);
                break;
            }
        }
    }
}
