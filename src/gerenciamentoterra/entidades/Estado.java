package gerenciamentoterra.entidades;

public class Estado {
    private String nome;
    private String sigla;
    private int contMun = 0; 
    private int quantidadeMunicipios;
    
    private Municipio[] municipios;

    public int getQuantidadeMunicipiosInseridos() {
        return contMun;
    }

    public Municipio[] getMunicipios() {
        return municipios;
    }
    
    public Estado(int quantidadeMunicipios) {
        this.municipios = new Municipio[quantidadeMunicipios];
    }
    
    public boolean adicionarMunicipio(Municipio m){
        if(contMun < quantidadeMunicipios){
            municipios[contMun++] = m;
            return true;
        }
        else {
            return false;
        }
    }
    public double areaEstado(){
        double areaEstado = 0;
        for (int i = 0; i < municipios.length; i++) {
            areaEstado += municipios[i].getArea();
            
        }
        return areaEstado;
    }
    public double popEstado(){
        double popEstado = 0;
        for (int i = 0; i < municipios.length; i++) {
            popEstado += municipios[i].getPopulacao();
            
        }
        return popEstado;
    }
    public boolean removerMunicipio(String n){
        int j = 0;
        Municipio[] aux = new Municipio[contMun-1];
        if(contMun >= 0){
            for (int i = 0; i < contMun; i++) {
                if(!municipios[i].getNome().equals(n)){
                    aux[j++] = municipios[i]; 
                }
            }
            for (int i = 0; i < aux.length; i++) {
                municipios[i] = aux[i];
                
            }
            contMun--;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

	public Municipio getMunicipioPorNome(String nome) {
		for (int i = 0; i < municipios.length; i++) {
            Municipio municipio = municipios[i];
            
            if(municipio.getNome().equals(nome)) {
                return municipio;
            }
        }
        
        return null;
	}
}
