/*
 * Classe para realizar todos as regras do sistemas referentes aos objetos da classe Pais
 */
package gerenciamentoterra;

import gerenciamentoterra.entidades.*;
import java.util.*;


public class GerenciamentoPais {
    public void gerenciarPais(PlanetaTerra planetaTerra) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***GERENCIAMENTO DE Pais***");
        int opcao;

        do {
            System.out.println("Digite a opção desejada: " + "\n 1-Ver todos Paises" + "\n 2-Pesquisar por um Pais"
                    + "\n 3-Inserir Pais" + "\n 4-Remover Pais" + "\n 5-Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
            case 1: {

                System.out.println("Paises ");
                for (int i = 0; i < planetaTerra.getQuantidadeContinentesInseridos(); i++) {
                    Continente continente = planetaTerra.getContinentes()[i];

                    for (int j = 0; j < continente.getQuantidadePaisesInseridos(); j++) {
                        Pais pais = continente.getPaises()[j];
                            System.out.println("Nome: " + pais.getNome() + " Sigla: " + pais.getCodigo()
                                    + " Quantidade estados: " + pais.getQuantidadeEstadosInseridos());
                    }

                }

                break;
            }
            case 2: {
                System.out.println("Digite nome do continente que deseja encontrar: ");
                String nomeContinente = scanner.nextLine();
                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);

                if (continente != null) {
                    System.out.println("Digite nome do pais que deseja encontrar: ");
                    String nomePais = scanner.nextLine();
                    Pais pais = continente.getPaisPorNome(nomePais);

                    if (pais != null) { 

                            System.out.println("Nome: " + pais.getNome() + " Sigla: " + pais.getCodigo()
                                    + " Quantidade municipios: " + pais.getQuantidadeEstadosInseridos());
                       
                    } else {
                        System.out.println("Pais invalido!");
                    }
                } else {
                    System.out.println("Continente invalido!");
                }

                break;
            }
            case 3: { 
                System.out.println("Informe o nome do Continente:");
                String nomeContinente = scanner.nextLine();
                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);
                if (continente.getQuantidadePaisesInseridos() < continente.getPaises().length) {
                    System.out.println("Informe a QUANTIDADE de Estados do Pais:");
                    int quantidadeEstados = scanner.nextInt();
                    scanner.nextLine();

                    Pais Pais = new Pais(quantidadeEstados);
                    System.out.println("Informe o nome do Pais:");
                    String nome = scanner.nextLine();
                    Pais.setNome(nome);

                    continente.adicionarPais(Pais);
                } else {
                    System.out.println("A quantidade máxima de Paises do planeta Terra foi atingida.");
                }
                break;
            }
            case 4: {
                System.out.println("Informe o nome do Continente");
                String nomeContinente = scanner.nextLine();
                System.out.println("Informe o nome do Pais");
                String nomePais = scanner.nextLine();
                

                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);
                

                continente.removerPais(nomePais);

                break;
            }
            }
        } while (opcao != 5);
    }
    
}
