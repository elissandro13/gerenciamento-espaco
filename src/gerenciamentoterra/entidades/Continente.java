/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentoterra.entidades;

public class Continente { 
    public String nome;
    private Pais[] paises;
    private int quantidadePaises;
    private int contPaises = 0;

    public int getQuantidadePaisesInseridos() {
        return contPaises;
    }
    
    public double popContinente(){
        double pop = 0;
        for (int i = 0; i < paises.length; i++) {
            pop += paises[i].popPais();
            
        }
        return pop;
    }
    public double areaContinente(){
        double area = 0;
        for (int i = 0; i < paises.length; i++) {
            area += paises[i].areaPais();
            
        }
                
        return area;
    }
    public double densidade(){
        return popContinente()/areaContinente();
    }
    public boolean adicionarPais(Pais m){
        if(contPaises < quantidadePaises){
            paises[contPaises++] = m;
            return true;
        }
        else {
            return false;
        }
    }
    
    public Pais maiorArea (){
        Pais maior;
        maior = paises[0];
        for (int i = 1; i < paises.length; i++) {
            if(paises[i].areaPais() > maior.areaPais()){
                maior = paises[i];
            }    
            
        }
        return maior;
    }
    public Pais menorArea (){
        Pais menor;
        menor = paises[0];
        for (int i = 1; i < paises.length; i++) {
            if(paises[i].areaPais() < menor.areaPais()){
                menor = paises[i];
            }    
            
        }
        return menor;
    }
    public Pais maiorPop(){
        Pais maior;
        maior = paises[0];
        for (int i = 1; i < paises.length; i++) {
            if(paises[i].popPais() > maior.areaPais()){
                maior = paises[i];
            }    
            
        }
        return maior;
    }
    public Pais menorPop(){
        Pais menor;
        menor = paises[0];
        for (int i = 1; i < paises.length; i++) {
            if(paises[i].areaPais() < menor.popPais()){
                menor = paises[i];
            }    
            
        }
        return menor;
    }
  
    public double razao(){
        return maiorArea().areaPais()/menorArea().areaPais();
    }
    
    public boolean removerPais(String n){
        int j = 0;
        Pais[] aux = new Pais[contPaises-1];
        if(contPaises >= 0){
            for (int i = 0; i < contPaises; i++) {
                if(!paises[i].getNome().equals(n)){
                    aux[j++] = paises[i]; 
                }
            }
            for (int i = 0; i < aux.length; i++) {
                paises[i] = aux[i];
                
            }
            contPaises--;
            return true;
        }
        else {
            return false;
        }
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais[] getPaises() {
        return paises;
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }

    public Continente(int quantidadePaises) {
        this.paises = new Pais[quantidadePaises];
    }

    public Pais getPaisPorNome(String nomePais) {
        for (int i = 0; i < paises.length; i++) {
            Pais pais = paises[i];
            
            if(pais.getNome().equals(nomePais)) {
                return pais;
            }
        }
        return null;
    }
}
