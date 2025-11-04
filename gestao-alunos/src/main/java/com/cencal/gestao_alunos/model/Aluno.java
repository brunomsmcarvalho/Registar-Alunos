package com.cencal.gestao_alunos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mini aplicação WEB com uso de modelo MVC
 * Gestão de alunos
 * Classe Aluno
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Aluno{
    private String nome;
    private String email;
    private int idade;
    private String matricula;


}