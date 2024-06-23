package com.alura.forumbhub.domain;

public enum Curso {
    JAVA("Java"),
    C("C"),
    CPLUSPLUS("C++"),
    GOLANG("Go Lang"),
    PYTHON("Python"),
    HTML("HTML"),
    CSS("CSS");

    private String linguagem;

    Curso(String curso) {
        this.linguagem = curso;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public static Curso getCurso(String texto) {
        for (Curso curso : Curso.values()) {
            if(curso.linguagem.equalsIgnoreCase(texto)) {
                return (curso);
            }
        }
        throw new IllegalArgumentException("Curso não encontrado");
    }
}
