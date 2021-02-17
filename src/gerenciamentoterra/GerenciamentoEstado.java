/*
 * Classe para realizar todos as regras do sistemas referentes aos objetos da classe Estado
 */
package gerenciamentoterra;

import gerenciamentoterra.entidades.Continente;
import gerenciamentoterra.entidades.Estado;
import gerenciamentoterra.entidades.Pais;
import gerenciamentoterra.entidades.PlanetaTerra;
import java.util.Scanner;

/**
 *
 * 
 */
public class GerenciamentoEstado {

    public void gerenciarEstado(PlanetaTerra planetaTerra) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***GERENCIAMENTO DE ESTADO***");
        int opcao;

        do {
            System.out.println("Digite a opção desejada: " + "\n 1-Ver todos Estados" + "\n 2-Pesquisar por um Estado"
                    + "\n 3-Inserir Estado" + "\n 4-Remover estado" + "\n 5-Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
            case 1: {

                System.out.println("Estados ");
                for (int i = 0; i < planetaTerra.getQuantidadeContinentesInseridos(); i++) {
                    Continente continente = planetaTerra.getContinentes()[i];

                    for (int j = 0; j < continente.getQuantidadePaisesInseridos(); j++) {
                        Pais pais = continente.getPaises()[j];

                        for (int k = 0; k < pais.getQuantidadeEstadosInseridos(); k++) {
                            Estado estado = pais.getEstados()[k];

                            System.out.println("Nome: " + estado.getNome() + " Sigla: " + estado.getSigla()
                                    + " Quantidade municipios: " + estado.getQuantidadeMunicipiosInseridos());

                        }

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
                        System.out.println("Digite nome do estado que deseja encontrar: ");
                        String nome = scanner.nextLine();

                        Estado estado = pais.getEstadoPorNome(nome);

                        if (estado != null) {
                            System.out.println("Nome: " + estado.getNome() + " Sigla: " + estado.getSigla()
                                    + " Quantidade municipios: " + estado.getQuantidadeMunicipiosInseridos());
                        } else {
                            System.out.println("Estado não encontrado!");
                        }
                    } else {
                        System.out.println("Pais invalido!");
                    }
                } else {
                    System.out.println("Continente invalido!");
                }

                break;
            }
            case 3: {
                System.out.println("Informe o nome do Pais:");
                String nomePais = scanner.nextLine();

                System.out.println("Informe o nome do Continente:");
                String nomeContinente = scanner.nextLine();
                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);
                Pais pais = continente.getPaisPorNome(nomePais);
                if (pais.getQuantidadeEstadosInseridos() < pais.getEstados().length) {
                    System.out.println("Informe a QUANTIDADE de Municipios do estado:");
                    int quantidadeMunicipios = scanner.nextInt();
                    scanner.nextLine();

                    Estado estado = new Estado(quantidadeMunicipios);
                    System.out.println("Informe o nome do Estado:");
                    String nome = scanner.nextLine();
                    estado.setNome(nome);

                    pais.adicionarEstado(estado);
                } else {
                    System.out.println("A quantidade máxima de estados do planeta Terra foi atingida.");
                }
                break;
            }
            case 4: {
                System.out.println("Informe o nome do Continente");
                String nomeContinente = scanner.nextLine();
                System.out.println("Informe o nome do Pais");
                String nomePais = scanner.nextLine();
                System.out.println("Informe o nome do Estado:");
                String nome = scanner.nextLine();

                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);
                Pais pais = continente.getPaisPorNome(nomePais);

                pais.removerEstado(nome);

                break;
            }
            }
        } while (opcao != 5);
    }
}
