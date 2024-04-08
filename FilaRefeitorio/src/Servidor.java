public abstract class Servidor extends Pessoa{
    private String siape;

    public Servidor(String nome, String siape) {
        super(nome);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
}
