/*
 * Classe para realizar todos as regras do sistemas referentes aos objetos da classe Continente
 */
package gerenciamentoterra;

import gerenciamentoterra.entidades.PlanetaTerra;
import gerenciamentoterra.entidades.Continente;
import java.util.Scanner;

public class GerenciamentoContinente {

    public void inserirContinente(PlanetaTerra planetaTerra) {

    }

    public void gerenciarContinente(PlanetaTerra planetaTerra) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***GERENCIAMENTO DE CONTINENTES***");
        int opcao;

        do {
            System.out.println("Digite a opção desejada: "
                    + "\n 1-Ver todos Continetes"
                    + "\n 2-Pesquisar por um Continete"
                    + "\n 3-Inserir Continete"
                    + "\n 4-Remover continente"
                    + "\n 5-Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    //se o vetor ainda não foi instanciado no construtor ele será igual a null
                    if (planetaTerra.getQuantidadeContinentesInseridos() == 0) {
                        System.out.println("Nenhum continente encontrado!");
                    } else {
                        System.out.println("Continentes ");
                        for (int i = 0; i < planetaTerra.getQuantidadeContinentesInseridos(); i++) {
                            Continente continente = planetaTerra.getContinentes()[i];

                            System.out.println("Nome: " + continente.getNome()
                                    + " Quantidade paises: " + continente.getPaises().length);
                        }
                    }
                    break;
                }
                case 2: {
                    //se o vetor ainda não foi instanciado no construtor ele será igual a null
                    if (planetaTerra.getContinentes() == null) {
                        System.out.println("Nenhum continente encontrado!");
                    } else {
                        System.out.println("Digite nome do continente que deseja encontrar: ");
                        String nome = scanner.nextLine();
                        
                        Continente continente = planetaTerra.getContinentePorNome(nome);
                        
                        if(continente != null) {
                            System.out.println("Continetne ");
                            System.out.println("Nome: " + continente.getNome()
                            + "Quantidade paises: " + continente.getPaises().length);
                        } else {
                            System.out.println("Continente não encontrado!");
                        }
                    }
                    break;
                }
                case 3: {
                    if(planetaTerra.getQuantidadeContinentesInseridos() < planetaTerra.getContinentes().length) {
                        System.out.println("Informe a QUANTIDADE de paises do continente:");
                       int quantidadePaises = scanner.nextInt();
                       scanner.nextLine();
                       
                       Continente continente = new Continente(quantidadePaises);
                       System.out.println("Informe o nome do Continete:");
                       String nome = scanner.nextLine();

                       continente.setNome(nome);
                       planetaTerra.adicionarContinente(continente);
                    } else {
                        System.out.println("A quantidade máxima de continentes do planeta Terra foi atingida.");
                    }
                    break;
                }
                case 4: {
                     System.out.println("Informe o nome do Continete:");
                       String nome = scanner.nextLine();

                      planetaTerra.removerContinente(nome);
                      
                    break;
                }
            }
        } while (opcao != 5);
    }

}
