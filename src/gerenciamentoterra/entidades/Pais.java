package gerenciamentoterra.entidades;

public class Pais {
    private Estado[] estados;
    private int quantidadeEstados;
    private int contEst = 0,contFront = 0;
    private Pais[] fronteira;
    private String nome,codigo;

    public Estado[] getEstados() {
        return estados;
    }

    public int getQuantidadeEstadosInseridos() {
        return contEst;
    }

    public void PaisesFronteira(int quantidade){
        this.fronteira = new Pais[quantidade];
    }
    public void paisesComuns(Pais p){
        for (int i = 0; i < fronteira.length; i++) {
            for (int j = 0; j < p.fronteira.length; j++) {
                if(fronteira[i].getCodigo().equals(p.fronteira[j].getCodigo())){
                    System.out.println(fronteira[i].getNome());
                }
                
                
            }
        }
    }    
    public boolean fazFronteira(Pais p){
        boolean flag = false;
        for (int i = 0; i < fronteira.length; i++) {
            if(p.getNome().equals(fronteira[i].getNome())){
                flag = true;
            }
            
        }
        return flag;
            
        
    }
    public boolean CompararPaises(Pais p){
        return p.getCodigo().equals(codigo);
    }
    public double areaPais(){
        double area = 0;
        for (int i = 0; i < estados.length; i++) {
            area += estados[i].areaEstado();
            
            
        }       
        return area;
    }
    public double popPais(){
        double pop = 0;
        for (int i = 0; i < estados.length; i++) {
            pop += estados[i].popEstado();
            
        }
        return pop;
    }
    public double densidade(){
        return areaPais()/popPais();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Pais(int quantidadeEstados) {
        this.estados = new Estado[quantidadeEstados];
    }
    
    public boolean adicionarEstado(Estado m){
        if(contEst < quantidadeEstados){
            estados[contEst++] = m;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean removerEstado(String n){
        int j = 0;
        Estado[] aux = new Estado[contEst-1];
        if(contEst >= 0){
            for (int i = 0; i < contEst; i++) {
                if(!estados[i].getNome().equals(n)){
                    aux[j++] = estados[i]; 
                }
            }
            for (int i = 0; i < aux.length; i++) {
                estados[i] = aux[i];
                
            }
            contEst--;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean adicionarFronteira(Pais m){
        if(contFront < quantidadeEstados){
            fronteira[contFront++] = m;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean removerFronteira(String n){
        int j = 0;
        Pais[] aux = new Pais[contFront-1];
        if(contEst >= 0){
            for (int i = 0; i < contEst; i++) {
                if(!estados[i].getNome().equals(n)){
                    aux[j++] = fronteira[i]; 
                }
            }
            for (int i = 0; i < aux.length; i++) {
                fronteira[i] = aux[i];
                
            }
            contFront--;
            return true;
        }
        else {
            return false;
        }
    }

    public Estado getEstadoPorNome(String nome) {
        for (int i = 0; i < estados.length; i++) {
            Estado estado = estados[i];
            
            if(estado.getNome().equals(nome)) {
                return estado;
            }
        }
        
        return null;
    }
	
}
