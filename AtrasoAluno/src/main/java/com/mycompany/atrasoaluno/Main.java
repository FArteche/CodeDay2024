package com.mycompany.atrasoaluno;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //CRIAR ALUNO

        Aluno aluno = new Aluno(null, null, null, 0);

        try {
            aluno.criarAlunoBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //CRIAR FUNCIONARIO

        Funcionario funcionario = new Funcionario(null, null, null, 0);

        try {
            funcionario.criarFuncionarioBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //CRIAR ATRASO

        Atraso atraso = new Atraso(aluno, null, null, null, funcionario);

        try {
            atraso.criarAtrasoBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
