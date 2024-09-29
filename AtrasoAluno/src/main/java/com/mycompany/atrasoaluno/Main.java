package com.mycompany.atrasoaluno;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //CRIAR ALUNO

        Aluno aluno = new Aluno("Joseph", "+1111111", "jojo@gmail.com", 2);

        try {
            aluno.criarAlunoBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //CRIAR FUNCIONARIO

        Funcionario funcionario = new Funcionario("Joselino", "+5555555", "joselino@gmail.com", 1);

        try {
            funcionario.criarFuncionarioBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //CRIAR ATRASO

    Atraso atraso = new Atraso(aluno, "25-09-2024", "12:22", "Trânsito", funcionario);

        try {
            atraso.criarAtrasoBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
