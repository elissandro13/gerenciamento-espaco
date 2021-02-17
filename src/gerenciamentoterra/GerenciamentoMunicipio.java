/*
 * Classe para realizar todos as regras do sistemas referentes aos objetos da classe Municipio
 */
package gerenciamentoterra;

import gerenciamentoterra.entidades.*;
import java.util.*;

/**
 *
 * 
 */
public class GerenciamentoMunicipio {
    public void gerenciarMunicipio(PlanetaTerra planetaTerra) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***GERENCIAMENTO DE Municipio**");
        int opcao;

        do {
            System.out.println("Digite a opção desejada: " + "\n 1-Ver todos Estados" + "\n 2-Pesquisar por um Estado"
                    + "\n 3-Inserir Estado" + "\n 4-Remover estado" + "\n 5-Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
            case 1: {

                System.out.println("Municipios ");
                for (int i = 0; i < planetaTerra.getQuantidadeContinentesInseridos(); i++) {
                    Continente continente = planetaTerra.getContinentes()[i];

                    for (int j = 0; j < continente.getQuantidadePaisesInseridos(); j++) {
                        Pais pais = continente.getPaises()[j];

                        for (int k = 0; k < pais.getQuantidadeEstadosInseridos(); k++) {
                            Estado estado = pais.getEstados()[k];
                            for (int h = 0; h < estado.getQuantidadeMunicipiosInseridos(); h++) {
                                Municipio municipio = estado.getMunicipios()[h];
                                System.out.println("Nome: " + municipio.getNome() + " Sigla: " + municipio.getCoordenada());

                            }

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
                            System.out.println("Digite o nome do municipio que dejesa encontrar: "); 
                            String nomeMunicipio = scanner.nextLine();
                            Municipio municipio = estado.getMunicipioPorNome(nomeMunicipio);
                            if (municipio != null){
                                System.out.println("Nome: " + estado.getNome() + " Sigla: " + estado.getSigla()
                                        + " Quantidade municipios: " + estado.getQuantidadeMunicipiosInseridos());

                            } else {
                                System.out.println("Municipio nao encontrado!");
                            }

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
                System.out.println("Informe o nome do Estado:");
                String nome = scanner.nextLine();
                String nomeContinente = scanner.nextLine();
                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);
                Pais pais = continente.getPaisPorNome(nomePais);
                Estado estado = pais.getEstadoPorNome(nome);

                if (estado.getQuantidadeMunicipiosInseridos() < estado.getMunicipios().length) {
                    System.out.println("Informe a QUANTIDADE de Municipios do estado:");
                    int quantidadeMunicipios = scanner.nextInt();
                    scanner.nextLine();

                    Municipio municipio = new Municipio();
                    System.out.println("Informe o nome do Municipio:");
                    String nomeMunicipio = scanner.nextLine();
                    estado.setNome(nomeMunicipio);

                    estado.adicionarMunicipio(municipio);
                } else {
                    System.out.println("A quantidade máxima de municipios do planeta Terra foi atingida.");
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
                System.out.println("Informe o nome do Municipio");
                String nomeMunicipio = scanner.nextLine();
                Continente continente = planetaTerra.getContinentePorNome(nomeContinente);
                Pais pais = continente.getPaisPorNome(nomePais);
                Estado estado = pais.getEstadoPorNome(nome);

                estado.removerMunicipio(nomeMunicipio);

                break;
            }
            }
        } while (opcao != 5);
    }

}
