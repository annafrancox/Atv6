package disciplina;

import usuario.Professor;

public class DisciplinaSemestre {
    private Disciplina disciplina;
    private Professor professor;
    private String semestre;

    public DisciplinaSemestre(Disciplina disciplina, Professor professor, String semestre) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
