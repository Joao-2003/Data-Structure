public class Professor extends Servidor{
    private String titulacao;

    public Professor(String nome, String siape, String titulacao) {
        super(nome, siape);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String toString() {
        return "Professor - SIAPE: " + getSiape() + ", Nome: " + getNome() + ", Titulação: " + titulacao;
    }
}
