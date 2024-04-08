public class Aluno extends Pessoa{
    private String matricula;
    private String curso;

    public Aluno(String nome, String curso, String matricula) {
        super(nome);
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno - Matrícula: " + matricula + ", Nome: " + getNome() + ", Curso: " + curso;
    }
}
