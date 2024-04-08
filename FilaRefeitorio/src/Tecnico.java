public class Tecnico extends Servidor{

    public Tecnico(String nome, String siape) {
        super(nome, siape);
    }

    @Override
    public String toString() {
        return "Técnico - SIAPE: " + getSiape() + ", Nome: " + getNome();
    }
}
