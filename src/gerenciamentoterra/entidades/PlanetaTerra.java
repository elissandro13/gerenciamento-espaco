/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentoterra.entidades;

public class PlanetaTerra {

    private Continente[] continentes;
    private int quantidadeContinentesInseridos = 0;

    public int getQuantidadeContinentesInseridos() {
        return quantidadeContinentesInseridos;
    }

    public Continente[] getContinentes() {
        return continentes;
    }

    public void setContinentes(Continente[] continentes) {
        this.continentes = continentes;
    }

    public PlanetaTerra(int quantidadeContinentes) {
        this.continentes = new Continente[quantidadeContinentes];
    }

    public boolean adicionarContinente(Continente continente) {
        if (this.quantidadeContinentesInseridos < this.continentes.length) {
            this.continentes[quantidadeContinentesInseridos] = continente;
            this.quantidadeContinentesInseridos++;
            return true;
        } else {
            return false;
        }
    }

    public boolean removerContinente(String nome) {
        for (int i = 0; i <  this.quantidadeContinentesInseridos; i++) {
            Continente c = this.getContinentes()[i];

            if (c.getNome().equals(nome)) {
                for (int j = i; j < this.getQuantidadeContinentesInseridos(); j++) {
                    if(j + 1 < this.getContinentes().length){
                        this.getContinentes()[j] = this.getContinentes()[j + 1];
                    }
                    this.quantidadeContinentesInseridos--;
                    return true;
                }
            }
        }

        return false;
    }

    public Continente getContinentePorNome(String nome) {
        for (int i = 0; i < this.getQuantidadeContinentesInseridos(); i++) {
            Continente continente = this.getContinentes()[i];

            //para comparar se duas string são iguais deve ser utilizado o método equals
            if (continente.getNome().equals(nome)) {
                return continente;
            }
        }
        
        return null;
    }
}
