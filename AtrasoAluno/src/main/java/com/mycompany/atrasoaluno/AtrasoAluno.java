/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atrasoaluno;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author faart
 */
public class AtrasoAluno extends JFrame implements ActionListener {

    ConDB condb = new ConDB();

    /*MAIN - JANELA PRINCIPAL
      PLACEHOLDER - CARDLAYOUT PARA MENUS*/
    Container main, placeHolder;

    /*MENU PRINCIPAL*/
    JButton alunoMB, funcionarioMB, turmaMB, atrasoMB;
    Container mainMenu, label;

    /*MENU ALUNOS*/
    Container alunoFrmae, alunoMenu, alunoCL, alunoAddF, alunoUpdateF, alunoDelF;
    JButton alunoMenuAdd, alunoMenuUpd, alunoMenuDel, alunoAddConf, alunoUpdConf, alunoDelConf, confUpdAluno;

    JTextField nomeAlunoAdd = new JTextField(50);
    JTextField telefoneAlunoAdd = new JTextField(50);
    JTextField emailAlunoAdd = new JTextField(50);
    JComboBox turmaAlunoAdd = new JComboBox();

    JComboBox boxAlunoUpd = new JComboBox();
    JTextField nomeAlunoUpd = new JTextField(50);
    JTextField telefoneAlunoUpd = new JTextField(50);
    JTextField emailAlunoUpd = new JTextField(50);
    JComboBox turmaAlunoUpd = new JComboBox();

    JComboBox boxAlunoDel = new JComboBox();

    /*MENU TURMA*/
    Container autorFrame, autorMenu, autorCL, autorAddF, autorUpdateF, autorDelF, autorListar, selectAutor;
    JButton autorMenuAdd, autorMenuUpd, autorMenuDel, autorMenuListar, autorAddConf, autorUpdConf, autorDelConf, autorListConf;

    JTextField turmaNomeAdd = new JTextField(50);
    JTextField turmaNomeUpd = new JTextField(50);

    JComboBox boxTurmarUpd = new JComboBox();

    JComboBox boxTurmaDel = new JComboBox();

    JComboBox boxTurmaList = new JComboBox();

    /*MENU FUNCIONARIO*/
    Container membroFrame, membroMenu, membroCL, membroAddF, membroUpdateF, membroDelF, membroListar, selectMembro;
    JButton membroMenuAdd, membroMenuUpd, membroMenuDel, membroMenuListar, membroAddConf, membroUpdConf, membroDelConf, membroListConf, confUpdMembro;

    JTextField nomeFuncionarioAdd = new JTextField(50);
    JTextField telefoneFuncionarioAdd = new JTextField(50);
    JTextField emailFuncionarioAdd = new JTextField(50);
    JComboBox tipoFuncionarioAdd = new JComboBox();

    JComboBox boxFuncionarioUpd = new JComboBox();
    JTextField nomeFuncionarioUpd = new JTextField(50);
    JTextField telefoneFuncionarioUpd = new JTextField(50);
    JTextField emaiFuncionarioUpd = new JTextField(50);
    JComboBox tipoFuncionarioUpd = new JComboBox();

    JComboBox boxFuncionarioDel = new JComboBox();

    JComboBox boxFuncionarioList = new JComboBox();
    JLabel listarMembroTextoEdit = new JLabel("");

    JLabel titulo = new JLabel("Registro de Atrasos de Alunos");

    /*MENU ATRASO*/
    Container atrasoFrame, atrasoMenu, atrasoCL, atrasoAddF, atrasoUpdateF, atrasoDelF, atrasoListar, selectAtraso;
    JButton atrasoMenuAdd, atrasoMenuUpd, atrasoMenuDel, atrasoMenuListar, atrasoAddConf, atrasoUpdConf, atrasoDelConf, atrasoListConf;

    JComboBox atrasoAlunoAdd = new JComboBox();
    JComboBox atrasoTurmaAdd = new JComboBox();
    JComboBox atrasoProfessorAdd = new JComboBox();
    JTextField atrasoJustificativaAdd = new JTextField(100);

    JComboBox atrasoAlunoUpd = new JComboBox();
    JComboBox atrasoTurmaUpd = new JComboBox();
    JComboBox atrasoProfessorUpd = new JComboBox();
    JTextField atrasoJustificativaUpd = new JTextField(100);

    public AtrasoAluno() {

        /*Janela Principal e Menu Principal----------------------------------------------------------------------------------*/

 /*Frames-----------------------------------------------------------------------------------------------------*/
        super("Registro de Atrasos de Alunos");
        main = getContentPane();
        main.setLayout(new BorderLayout(10, 10));
        main.setBackground(Color.darkGray);
        placeHolder = new JPanel(new CardLayout(20, 20));
        placeHolder.setBackground(Color.LIGHT_GRAY);
        label = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 10));
        label.setBackground(Color.yellow);
        mainMenu = new JPanel(new GridLayout(1, 4, 10, 10));
        mainMenu.setBackground(Color.yellow);

        /*Botôes-----------------------------------------------------------------------------------------------------*/
        alunoMB = new JButton("Alunos");
        alunoMB.addActionListener(this);
        funcionarioMB = new JButton("Turmas");
        funcionarioMB.addActionListener(this);
        turmaMB = new JButton("Funcionarios");
        turmaMB.addActionListener(this);
        atrasoMB = new JButton("Atrasos");
        atrasoMB.addActionListener(this);
        

        /*Montar o Menu Principal------------------------------------------------------------------------------------*/
        mainMenu.add(alunoMB);
        mainMenu.add(funcionarioMB);
        mainMenu.add(turmaMB);
        mainMenu.add(atrasoMB);

        label.add(titulo);
        label.add(mainMenu);

        main.add(BorderLayout.NORTH, label);
        main.add(BorderLayout.CENTER, placeHolder);

        /*Alunos-------------------------------------------------------------------------------------------------------------*/
 /*Frames Principais------------------------------------------------------------------------------------------*/
        alunoFrmae = new JPanel(new BorderLayout(10, 10));
        alunoFrmae.setBackground(Color.LIGHT_GRAY);
        alunoMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        alunoMenu.setBackground(Color.LIGHT_GRAY);
        alunoCL = new JPanel(new CardLayout());
        alunoCL.setBackground(Color.LIGHT_GRAY);

        /*Menu Livros------------------------------------------------------------------------------------------------*/
        alunoMenuAdd = new JButton("Adicionar");
        alunoMenuAdd.addActionListener(this);
        alunoMenuUpd = new JButton("Atualizar");
        alunoMenuUpd.addActionListener(this);
        alunoMenuDel = new JButton("Deletar");
        alunoMenuDel.addActionListener(this);

        JLabel livroMenuLabel = new JLabel("Alunos");

        alunoMenu.add(livroMenuLabel);
        alunoMenu.add(alunoMenuAdd);
        alunoMenu.add(alunoMenuUpd);
        alunoMenu.add(alunoMenuDel);

        /*Adicionar Livro---------------------------------------------------------------------------------------------*/
        alunoAddF = new JPanel(new GridLayout(7, 2, 20, 50));
        alunoAddF.setBackground(Color.LIGHT_GRAY);
        alunoAddF.setVisible(false);
        alunoCL.add(alunoAddF, "adicionarLivro");

        JLabel livroAddNomeL = new JLabel("Nome: ");
        alunoAddF.add(livroAddNomeL);
        alunoAddF.add(nomeAlunoAdd);

        JLabel livroAddNumPagL = new JLabel("Telefone: ");
        alunoAddF.add(livroAddNumPagL);
        alunoAddF.add(telefoneAlunoAdd);

        JLabel edicaoAddNomeL = new JLabel("Email: ");
        alunoAddF.add(edicaoAddNomeL);
        alunoAddF.add(emailAlunoAdd);

        JLabel autorAddNomeL = new JLabel("Turma: ");
        alunoAddF.add(autorAddNomeL);
        alunoAddF.add(turmaAlunoAdd);

        alunoAddConf = new JButton("Confirmar");
        alunoAddConf.addActionListener(this);
        alunoAddF.add(alunoAddConf);

        /*Atualizar Livro-----------------------------------------------------------------------------------------------------*/
        alunoUpdateF = new JPanel(new GridLayout(7, 2, 20, 50));
        alunoUpdateF.setBackground(Color.LIGHT_GRAY);
        alunoUpdateF.setVisible(false);
        alunoCL.add(alunoUpdateF, "atualizarLivro");

        confUpdAluno = new JButton("Selecionar Aluno");
        confUpdAluno.addActionListener(this);
        alunoUpdateF.add(confUpdAluno);
        alunoUpdateF.add(boxAlunoUpd);

        JLabel livroUpdNomeL = new JLabel("Nome: ");
        alunoUpdateF.add(livroUpdNomeL);
        alunoUpdateF.add(nomeAlunoUpd);

        JLabel livroUpdNumPagL = new JLabel("Telefone: ");
        alunoUpdateF.add(livroUpdNumPagL);
        alunoUpdateF.add(telefoneAlunoUpd);

        JLabel edicaoUpdNomeL = new JLabel("Email: ");
        alunoUpdateF.add(edicaoUpdNomeL);
        alunoUpdateF.add(emailAlunoUpd);

        JLabel autorUpdNomeL = new JLabel("Turma: ");
        alunoUpdateF.add(autorUpdNomeL);
        turmaAlunoUpd.addActionListener(this);
        alunoUpdateF.add(turmaAlunoUpd);

        alunoUpdConf = new JButton("Atualizar");
        alunoUpdConf.addActionListener(this);
        alunoUpdateF.add(alunoUpdConf);

        /*Deletar Livro-----------------------------------------------------------------------------------------------------*/
        alunoDelF = new JPanel(new GridLayout(7, 2, 20, 50));
        alunoDelF.setBackground(Color.LIGHT_GRAY);
        alunoDelF.setVisible(false);
        alunoCL.add(alunoDelF, "deletarLivro");

        JLabel selectDelL = new JLabel("Selecione o Livro para deletar: ");
        alunoDelF.add(selectDelL);
        alunoDelF.add(boxAlunoDel);
        alunoDelConf = new JButton("Confirmar");
        alunoDelConf.addActionListener(this);
        alunoDelF.add(alunoDelConf);

        /*ADICIONAR LIVRO AO FRAME PRINCIPAL-----------------------------------------------------------------------------------------------------*/
        alunoFrmae.add(alunoMenu, BorderLayout.NORTH);
        alunoFrmae.add(alunoCL, BorderLayout.CENTER);
        placeHolder.add(alunoFrmae, "livros");

        /*AUTORES-----------------------------------------------------------------------------------------------------------------------------------------*/
 /*Frames Principais-----------------------------------------------------------------------------------------------------------------------*/
        autorFrame = new JPanel(new BorderLayout(10, 10));
        autorFrame.setBackground(Color.LIGHT_GRAY);
        autorMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        autorMenu.setBackground(Color.LIGHT_GRAY);
        autorCL = new JPanel(new CardLayout());
        autorCL.setBackground(Color.LIGHT_GRAY);
        autorCL.setVisible(false);

        /*Menu Autores----------------------------------------------------------------------------------------------------------------------------*/
        autorMenuAdd = new JButton("Adicionar");
        autorMenuAdd.addActionListener(this);
        autorMenuUpd = new JButton("Atualizar");
        autorMenuUpd.addActionListener(this);
        autorMenuDel = new JButton("Deletar");
        autorMenuDel.addActionListener(this);
        autorMenuListar = new JButton("Listar");
        autorMenuListar.addActionListener(this);

        JLabel autorMenuLabel = new JLabel("Turmas");

        autorMenu.add(autorMenuLabel);
        autorMenu.add(autorMenuAdd);
        autorMenu.add(autorMenuUpd);
        autorMenu.add(autorMenuDel);
        autorMenu.add(autorMenuListar);
        /*Autores Adicionar-----------------------------------------------------------------------------------------------------------------------*/
        autorAddF = new JPanel(new GridLayout(7, 2, 20, 50));
        autorAddF.setBackground(Color.LIGHT_GRAY);
        autorAddF.setVisible(false);
        autorCL.add(autorAddF, "adicionarAutor");

        JLabel autorAddNomeLa = new JLabel("Nome do Autor: ");
        autorAddF.add(autorAddNomeLa);
        autorAddF.add(turmaNomeAdd);

        autorAddConf = new JButton("Confirmar");
        autorAddConf.addActionListener(this);
        autorAddF.add(autorAddConf);

        /*Autores Atualizar-----------------------------------------------------------------------------------------------------------------------*/
        autorUpdateF = new JPanel(new GridLayout(7, 2, 20, 50));
        autorUpdateF.setBackground(Color.LIGHT_GRAY);
        autorUpdateF.setVisible(false);
        autorCL.add(autorUpdateF, "atualizarAutor");

        JLabel autorUpdSlctNomeLa = new JLabel("Nome do Autor a atualizar: ");
        autorUpdateF.add(autorUpdSlctNomeLa);
        boxTurmarUpd.addActionListener(this);
        autorUpdateF.add(boxTurmarUpd);

        JLabel autorUpdNomeLa = new JLabel("Novo nome do Autor: ");
        autorUpdateF.add(autorUpdNomeLa);
        autorUpdateF.add(turmaNomeUpd);

        autorUpdConf = new JButton("Confirmar");
        autorUpdConf.addActionListener(this);
        autorUpdateF.add(autorUpdConf);

        /*Autores Deletar-----------------------------------------------------------------------------------------------------------------------*/
        autorDelF = new JPanel(new GridLayout(7, 2, 20, 50));
        autorDelF.setBackground(Color.LIGHT_GRAY);
        autorDelF.setVisible(false);
        autorCL.add(autorDelF, "deletarAutor");

        JLabel selectDelA = new JLabel("Selecione o autor para deletar (Apenas autores sem livros podem ser deletados): ");
        autorDelF.add(selectDelA);
        autorDelF.add(boxTurmaDel);
        autorDelConf = new JButton("Confirmar");
        autorDelConf.addActionListener(this);
        autorDelF.add(autorDelConf);
        /*Autores Listar-----------------------------------------------------------------------------------------------------------------------*/
        autorListar = new JPanel(new BorderLayout(20, 20));
        autorListar.setBackground(Color.LIGHT_GRAY);
        autorListar.setVisible(false);

        selectAutor = new JPanel(new GridLayout(1, 2, 20, 20));
        selectAutor.setBackground(Color.LIGHT_GRAY);
        JLabel listarAutorTexto = new JLabel("Autores:");
        selectAutor.add(listarAutorTexto);
        selectAutor.add(boxTurmaList);
        autorListConf = new JButton("Confirmar");
        autorListConf.addActionListener(this);
        selectAutor.add(autorListConf);
        autorListar.add(selectAutor, BorderLayout.NORTH);

        autorCL.add(autorListar, "listarAutor");
        /*ADICIONAR AUTOR AO FRAME PRINCIPAL-----------------------------------------------------------------------------------------------------------------------*/
        autorFrame.add(autorMenu, BorderLayout.NORTH);
        autorFrame.add(autorCL, BorderLayout.CENTER);
        placeHolder.add(autorFrame, "autor");

        /*MEMBROS-----------------------------------------------------------------------------------------------------------------------------------------*/
 /*Frames Principais-----------------------------------------------------------------------------------------------------------------------*/
        membroFrame = new JPanel(new BorderLayout(10, 10));
        membroFrame.setBackground(Color.LIGHT_GRAY);
        membroMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        membroMenu.setBackground(Color.LIGHT_GRAY);
        membroCL = new JPanel(new CardLayout());
        membroCL.setBackground(Color.LIGHT_GRAY);
        membroCL.setVisible(false);

        /*Menu Membros------------------------------------------------------------------------------------------------*/
        membroMenuAdd = new JButton("Adicionar");
        membroMenuAdd.addActionListener(this);
        membroMenuUpd = new JButton("Atualizar");
        membroMenuUpd.addActionListener(this);
        membroMenuDel = new JButton("Deletar");
        membroMenuDel.addActionListener(this);
        membroMenuListar = new JButton("Listar");
        membroMenuListar.addActionListener(this);

        JLabel membroMenuLabel = new JLabel("Funcionarios");

        membroMenu.add(membroMenuLabel);
        membroMenu.add(membroMenuAdd);
        membroMenu.add(membroMenuUpd);
        membroMenu.add(membroMenuDel);
        membroMenu.add(membroMenuListar);

        /*Adicionar Membros---------------------------------------------------------------------------------------------*/
        membroAddF = new JPanel(new GridLayout(7, 2, 20, 50));
        membroAddF.setBackground(Color.LIGHT_GRAY);
        membroAddF.setVisible(false);
        membroCL.add(membroAddF, "adicionarMembro");

        JLabel membroAddNomeL = new JLabel("Nome do membro: ");
        membroAddF.add(membroAddNomeL);
        membroAddF.add(nomeFuncionarioAdd);

        JLabel membroCpfPagL = new JLabel("CPF: ");
        membroAddF.add(membroCpfPagL);
        membroAddF.add(telefoneFuncionarioAdd);

        JLabel membroTelefoneAddL = new JLabel("Telefone: ");
        membroAddF.add(membroTelefoneAddL);
        membroAddF.add(emailFuncionarioAdd);

        membroAddConf = new JButton("Confirmar");
        membroAddConf.addActionListener(this);
        membroAddF.add(membroAddConf);

        /*Atualizar Membros-----------------------------------------------------------------------------------------------------*/
        membroUpdateF = new JPanel(new GridLayout(7, 2, 20, 50));
        membroUpdateF.setBackground(Color.LIGHT_GRAY);
        membroUpdateF.setVisible(false);
        membroCL.add(membroUpdateF, "atualizarMembro");

        confUpdMembro = new JButton("Selecionar membro");
        confUpdMembro.addActionListener(this);
        membroUpdateF.add(confUpdMembro);
        membroUpdateF.add(boxFuncionarioUpd);

        JLabel membroUpdNomeL = new JLabel("Nome do membro: ");
        membroUpdateF.add(membroUpdNomeL);
        membroUpdateF.add(nomeFuncionarioUpd);

        JLabel cpfUpdL = new JLabel("CPF: ");
        membroUpdateF.add(cpfUpdL);
        membroUpdateF.add(telefoneFuncionarioUpd);

        JLabel telefoneUpdL = new JLabel("Telefone: ");
        membroUpdateF.add(telefoneUpdL);
        membroUpdateF.add(emaiFuncionarioUpd);

        JLabel atvidoUpd = new JLabel("É ativo ? ");
        membroUpdateF.add(atvidoUpd);
        membroUpdateF.add(tipoFuncionarioAdd);

        membroUpdConf = new JButton("Confirmar");
        membroUpdConf.addActionListener(this);
        membroUpdateF.add(membroUpdConf);
        membroUpdConf.setVisible(false);

        /*Deletar Membros-----------------------------------------------------------------------------------------------------*/
        membroDelF = new JPanel(new GridLayout(7, 2, 20, 50));
        membroDelF.setBackground(Color.LIGHT_GRAY);
        membroDelF.setVisible(false);
        membroCL.add(membroDelF, "deletarMembro");

        JLabel selectDelMembroL = new JLabel("Selecione o membro a ser deletado: ");
        membroDelF.add(selectDelMembroL);
        membroDelF.add(boxFuncionarioDel);
        membroDelConf = new JButton("Confirmar");
        membroDelConf.addActionListener(this);
        membroDelF.add(membroDelConf);

        /*Listar Membros-----------------------------------------------------------------------------------------------------*/
        membroListar = new JPanel(new BorderLayout(20, 20));
        membroListar.setBackground(Color.LIGHT_GRAY);
        membroListar.setVisible(false);

        membroCL.add(membroListar, "listarMembro");

        /*ADICIONAR LIVRO AO FRAME PRINCIPAL-----------------------------------------------------------------------------------------------------*/
        membroFrame.add(membroMenu, BorderLayout.NORTH);
        membroFrame.add(membroCL, BorderLayout.CENTER);
        placeHolder.add(membroFrame, "membros");
        
         /*ATRASO-------------------------------------------------------------------------------------------------------------*/
 /*Frames Principais------------------------------------------------------------------------------------------*/
        atrasoFrame = new JPanel(new BorderLayout(10, 10));
        atrasoFrame.setBackground(Color.LIGHT_GRAY);
        atrasoMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        atrasoMenu.setBackground(Color.LIGHT_GRAY);
        atrasoCL = new JPanel(new CardLayout());
        atrasoCL.setBackground(Color.LIGHT_GRAY);
        atrasoCL.setVisible(false);

        /*Menu Livros------------------------------------------------------------------------------------------------*/
        atrasoMenuAdd = new JButton("Adicionar");
        atrasoMenuAdd.addActionListener(this);
        atrasoMenuUpd = new JButton("Atualizar");
        atrasoMenuUpd.addActionListener(this);
        atrasoMenuListar = new JButton("Listar");
        atrasoMenuListar.addActionListener(this);

        JLabel atrasoMenuLabel = new JLabel("Atrasos");

        atrasoMenu.add(atrasoMenuAdd);
        atrasoMenu.add(atrasoMenuUpd);
        atrasoMenu.add(atrasoMenuListar);
        
        atrasoFrame.add(atrasoMenu,BorderLayout.NORTH);
        atrasoFrame.add(atrasoCL,BorderLayout.CENTER);
        placeHolder.add(atrasoFrame, "atrasos");

        /*Adicionar Livro---------------------------------------------------------------------------------------------*/
        atrasoAddF = new JPanel(new GridLayout(7, 2, 20, 50));
        atrasoAddF.setBackground(Color.LIGHT_GRAY);
        atrasoAddF.setVisible(false);
        atrasoCL.add(atrasoAddF, "adicionarAtraso");

        JLabel atrasoAlunoN = new JLabel("Aluno: ");
        atrasoAddF.add(atrasoAlunoN);
        atrasoAddF.add(atrasoAlunoAdd);

        JLabel atrasoProfessorN = new JLabel("Professor: ");
        atrasoAddF.add(atrasoProfessorN);
        atrasoAddF.add(atrasoProfessorAdd);

        JLabel atrasoTurmaN = new JLabel("Turma: ");
        atrasoAddF.add(atrasoTurmaN);
        atrasoAddF.add(atrasoTurmaAdd);

        JLabel atrasoJustificativaN = new JLabel("Justificativa: ");
        atrasoAddF.add(atrasoJustificativaN);
        atrasoAddF.add(atrasoJustificativaAdd);

        atrasoAddConf = new JButton("Confirmar");
        atrasoAddConf.addActionListener(this);
        atrasoAddF.add(atrasoAddConf);

        /*Atualizar Livro-----------------------------------------------------------------------------------------------------*/
        atrasoUpdateF = new JPanel(new GridLayout(7, 2, 20, 50));
        atrasoUpdateF.setBackground(Color.LIGHT_GRAY);
        atrasoUpdateF.setVisible(false);
        alunoCL.add(atrasoUpdateF, "atualizarLivro");

        JLabel livroUpdNomeLa = new JLabel("Aluno: ");
        atrasoUpdateF.add(livroUpdNomeLa);
        atrasoUpdateF.add(atrasoAlunoUpd);

        JLabel livroUpdNumPagLa = new JLabel("Professor: ");
        atrasoUpdateF.add(livroUpdNumPagLa);
        atrasoUpdateF.add(atrasoTurmaUpd);

        JLabel edicaoUpdNomeLa = new JLabel("Turma: ");
        atrasoUpdateF.add(edicaoUpdNomeLa);
        atrasoUpdateF.add(atrasoProfessorUpd);

        JLabel autorUpdNomeLaa = new JLabel("Justificativa: ");
        atrasoUpdateF.add(autorUpdNomeLaa);
        turmaAlunoUpd.addActionListener(this);
        atrasoUpdateF.add(atrasoJustificativaUpd);

        atrasoUpdConf = new JButton("Atualizar");
        atrasoUpdConf.addActionListener(this);
        atrasoUpdateF.add(atrasoUpdConf);
        /****LISTAR ATRASOS*/
        atrasoListar = new JPanel(new BorderLayout(20, 20));
        atrasoListar.setBackground(Color.LIGHT_GRAY);
        atrasoListar.setVisible(false);
        
        atrasoCL.add(membroListar, "listarAtraso");
        /*ADICIONAR LIVRO AO FRAME PRINCIPAL-----------------------------------------------------------------------------------------------------*/
        alunoFrmae.add(alunoMenu, BorderLayout.NORTH);
        alunoFrmae.add(alunoCL, BorderLayout.CENTER);
        placeHolder.add(alunoFrmae, "livros");

        /*------------------------------------------------------------------------------------------------------------------------------------------------*/
        placeHolder.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new AtrasoAluno();
    }

// FUNÇÃO BOTÕES //        
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            CardLayout clMain = (CardLayout) (placeHolder.getLayout());
            CardLayout clLivro = (CardLayout) (alunoCL.getLayout());
            CardLayout clAutor = (CardLayout) (autorCL.getLayout());
            CardLayout clMembro = (CardLayout) (membroCL.getLayout());
            CardLayout clAtraso = (CardLayout) (atrasoCL.getLayout());

            /*BOTÕES DO MENU PRINCIPAL*/
            if (e.getSource() == alunoMB) {
                placeHolder.setVisible(true);
                clMain.show(placeHolder, "livros");
                alunoCL.setVisible(false);
            }
            if (e.getSource() == funcionarioMB) {
                placeHolder.setVisible(true);
                clMain.show(placeHolder, "autor");
                autorCL.setVisible(false);
            }
            if (e.getSource() == turmaMB) {
                placeHolder.setVisible(true);
                clMain.show(placeHolder, "membros");
                membroCL.setVisible(false);
            }
            if (e.getSource() == atrasoMB) {
                placeHolder.setVisible(true);
                clMain.show(placeHolder, "atrasos");
                atrasoCL.setVisible(false);
            }

            /*BOTÕES DO MENU DE ALUNOS*/
            if (e.getSource() == alunoMenuAdd) {
                alunoCL.setVisible(true);
                clLivro.show(alunoCL, "adicionarLivro");
                titulo.setText("Adicionar Aluno");

                turmaAlunoAdd.setEnabled(true);
                turmaAlunoAdd.removeAllItems();

                nomeAlunoAdd.setText("");
                telefoneAlunoAdd.setText("");
                emailAlunoAdd.setText("");

                condb.returnTodasTurmas();
                for (Turma t : condb.arrayTurma) {
                    turmaAlunoAdd.addItem(t.getNome());
                }

            }
            if (e.getSource() == alunoAddConf) {

                String naa = nomeAlunoAdd.getText();
                String taa = telefoneAlunoAdd.getText();
                String eaa = emailAlunoAdd.getText();
                int taba = condb.getTurmaId(turmaAlunoAdd.getSelectedItem().toString());
                System.out.println(taba);
                Aluno aluno = new Aluno(naa, taa, eaa, taba);
                aluno.criarAlunoBD();

                nomeAlunoAdd.setText("");
                telefoneAlunoAdd.setText("");
                emailAlunoAdd.setText("");
            }
            if (e.getSource() == alunoMenuDel) {
                boxAlunoDel.removeAllItems();
                condb.returnTodosAlunos();

                for (Aluno a : condb.arrayAluno) {
                    boxAlunoDel.addItem(a.getNome());
                }
            }
            if (e.getSource() == alunoMenuUpd) {
                alunoCL.setVisible(true);
                clLivro.show(alunoCL, "atualizarLivro");
                titulo.setText("Atualizar Aluno");
                confUpdAluno.setEnabled(true);

                boxAlunoUpd.setEnabled(true);
                boxAlunoUpd.removeAllItems();
                turmaAlunoUpd.setEnabled(true);
                turmaAlunoUpd.removeAllItems();
                nomeAlunoUpd.setText("");
                telefoneAlunoUpd.setText("");
                emailAlunoUpd.setText("");
                turmaAlunoUpd.setSelectedItem(1);

                condb.returnTodosAlunos();
                for (Aluno a : condb.arrayAluno) {
                    boxAlunoUpd.addItem(a.getNome());
                }

                condb.returnTodasTurmas();
                for (Turma t : condb.arrayTurma) {
                    turmaAlunoUpd.addItem(t.getNome());
                }
            }
            if (e.getSource() == confUpdAluno) {
                Aluno aluno = condb.returnAlunoPorNome(boxAlunoUpd.getSelectedItem().toString());
                nomeAlunoUpd.setText(aluno.getNome());
                telefoneAlunoUpd.setText(aluno.getTelefone());
                emailAlunoUpd.setText(aluno.getEmail());
                turmaAlunoUpd.setSelectedItem(aluno.getTurmaNome());

                alunoUpdConf.setEnabled(true);
            }

            if (e.getSource() == alunoUpdConf) {

                System.out.println(boxAlunoUpd.getSelectedItem().toString());
                System.out.println(nomeAlunoUpd.getText());
                Aluno aluno = condb.returnAlunoPorNome(boxAlunoUpd.getSelectedItem().toString());
                aluno.atualizarAlunoDB(nomeAlunoUpd.getText(), telefoneAlunoUpd.getText(), emailAlunoUpd.getText(), condb.getTurmaId(turmaAlunoUpd.getSelectedObjects().toString()));

                nomeAlunoUpd.setText("");
                telefoneAlunoUpd.setText("");
                emailAlunoUpd.setText("");
            }

            /*BOTÕES DO MENU DE TURMA*/
            if (e.getSource() == autorMenuAdd) {
                autorCL.setVisible(true);
                clAutor.show(autorCL, "adicionarAutor");
                titulo.setText("Adicionar Turma");

                turmaNomeAdd.setText("");
            }
            if (e.getSource() == autorAddConf) {
                Turma turma = new Turma(turmaNomeAdd.getText());
                turma.criarTurma();
                turmaNomeAdd.setText("");
            }
            if (e.getSource() == autorMenuDel) {
                autorCL.setVisible(true);
                clAutor.show(autorCL, "deletarAutor");
                titulo.setText("Deletar Turma");
            }
            if (e.getSource() == autorDelConf) {

            }
            if (e.getSource() == autorMenuUpd) {
                autorCL.setVisible(true);
                clAutor.show(autorCL, "atualizarAutor");
                titulo.setText("Atualizar Turma");

                turmaNomeUpd.setText("");
                boxTurmarUpd.removeAllItems();

                condb.returnTodasTurmas();
                for (Turma t : condb.arrayTurma) {
                    boxTurmarUpd.addItem(t.getNome());
                }
            }
            if (e.getSource() == autorUpdConf) {
                Turma turma = condb.returnTurma(boxTurmarUpd.getSelectedItem().toString());
                turma.atualizarTurmaDB(turmaNomeUpd.getText());
            }
            if (e.getSource() == autorMenuListar) {
                autorCL.setVisible(true);
                clAutor.show(autorCL, "listarAutor");
                titulo.setText("Listar Turma");

                /**
                 * ***********TABELA VAI AQUI******************
                 */
            }
            if (e.getSource() == autorListConf) {

            }
            /*BOTÕES DO MENU DE MEMBROS*/
            if (e.getSource() == membroMenuAdd) {
                membroCL.setVisible(true);
                clMembro.show(membroCL, "adicionarMembro");
                titulo.setText("Adicionar Funcionario");

                tipoFuncionarioAdd.removeAllItems();

                nomeFuncionarioAdd.setText("");
                telefoneFuncionarioAdd.setText("");
                emailFuncionarioAdd.setText("");

                tipoFuncionarioAdd.addItem("Professor");
                tipoFuncionarioAdd.addItem("Funcionario");
            }
            if (e.getSource() == membroAddConf) {
                int tipo;
                if (tipoFuncionarioAdd.getSelectedItem().toString().equals("Professor")) {
                    tipo = 1;
                } else {
                    tipo = 2;
                }
                Funcionario funcionario = new Funcionario(nomeFuncionarioAdd.getText(), telefoneFuncionarioAdd.getText(), emailFuncionarioAdd.getText(), tipo);
                funcionario.criarFuncionarioBD();
            }
            if (e.getSource() == membroMenuDel) {
                membroCL.setVisible(true);
                clMembro.show(membroCL, "deletarMembro");
                titulo.setText("Deletar Funcionario");
            }
            if (e.getSource() == membroDelConf) {

            }
            if (e.getSource() == membroMenuUpd) {
                membroCL.setVisible(true);
                clMembro.show(membroCL, "atualizarMembro");
                titulo.setText("Atualizar Funcionario");

                confUpdMembro.setEnabled(true);

                boxFuncionarioUpd.setEnabled(true);
                boxFuncionarioUpd.removeAllItems();
                tipoFuncionarioUpd.setEnabled(true);
                tipoFuncionarioUpd.removeAllItems();

                nomeFuncionarioUpd.setText("");
                telefoneFuncionarioUpd.setText("");
                emaiFuncionarioUpd.setText("");
                tipoFuncionarioUpd.setSelectedItem(1);

                condb.returnTodosFuncionarios();
                for (Funcionario f : condb.arrayFuncionario) {
                    boxFuncionarioUpd.addItem(f.getNome());
                }

                tipoFuncionarioUpd.addItem("Professor");
                tipoFuncionarioUpd.addItem("Funcionario");

            }
            if (e.getSource() == confUpdMembro) {
                Funcionario funcionario = condb.returnFuncionarioPorNome(boxFuncionarioUpd.getSelectedItem().toString());
                nomeFuncionarioUpd.setText(funcionario.getNome());
                telefoneFuncionarioUpd.setText(funcionario.getTelefone());
                emaiFuncionarioUpd.setText(funcionario.getEmail());
                if (funcionario.getTipo() == 1) {
                    tipoFuncionarioUpd.setSelectedItem(1);
                } else {
                    tipoFuncionarioUpd.setSelectedItem(2);
                }

                confUpdMembro.setEnabled(true);
            }
            if (e.getSource() == membroUpdConf) {
                Funcionario funcionario = condb.returnFuncionarioPorNome(boxFuncionarioUpd.getSelectedItem().toString());
                int tipo;
                if (tipoFuncionarioUpd.getSelectedItem().toString().equals("Professor")) {
                    tipo = 1;
                } else {
                    tipo = 2;
                }
                funcionario.atualizarFuncionarioDB(nomeFuncionarioUpd.getText(), telefoneFuncionarioUpd.getText(), emaiFuncionarioUpd.getText(), tipo);
                nomeFuncionarioUpd.setText("");
                telefoneFuncionarioUpd.setText("");
                emaiFuncionarioUpd.setText("");
            }
            if (e.getSource() == membroMenuListar) {
                membroCL.setVisible(true);
                clMembro.show(membroCL, "listarMembro");
                listarMembroTextoEdit.setText("");
                titulo.setText("Listar Funcionario");
                
                condb.returnTodosFuncionariosProfessores();

                String[] colunas = {"Nome", "Telefone", "Email", "Tipo"};
                Object[][] dados = new Object[condb.arrayFuncionario.size()][4];

                int size = 0;
                for (Funcionario f : condb.arrayFuncionario) {
                    dados[size][0] = f.getNome();
                    dados[size][1] = f.getTelefone();
                    dados[size][2] = f.getEmail();
                    if (f.getTipo() == 1) {
                        dados[size][3] = "Professor";
                    } else {
                        dados[size][3] = "Funcionario";
                    }
                    size++;
                }

                DefaultTableModel modelo = new DefaultTableModel(dados, colunas) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Todas as células não são editáveis
                    }
                };

                JTable tabela = new JTable(modelo);

                // Opcional: Personalizações adicionais (como seleção de linha inteira)
                tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                tabela.setRowSelectionAllowed(true);
                tabela.setColumnSelectionAllowed(false);

                // Adiciona a tabela a um JScrollPane
                JScrollPane painelRolagem = new JScrollPane(tabela);

                // Adiciona o painel de rolagem ao frame
                membroListar.add(painelRolagem, BorderLayout.CENTER);

                // Torna o frame visível
                membroListar.setVisible(true);
            }
            if (e.getSource() == atrasoMenuListar) {
                atrasoListar.setVisible(true);
                atrasoCL.setVisible(true);
                clAtraso.show(atrasoCL, "listarAtraso");
                titulo.setText("Listar Atraso");
                
                condb.returnAtrasos();

                String[] colunas = {"Aluno", "Professor", "Data", "Hora", "Justificativa"};
                Object[][] dados = new Object[condb.arrayAtraso.size()][5];

                int size = 0;
                for (Atraso a : condb.arrayAtraso) {
                    dados[size][0] = a.getAluno().getNome();
                    dados[size][1] = a.getFuncionario().getNome();
                    dados[size][2] = a.getData();
                    dados[size][3] = a.getHora();
                    dados[size][4] = a.getJustificativa();
                }

                DefaultTableModel modelo = new DefaultTableModel(dados, colunas) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Todas as células não são editáveis
                    }
                };

                JTable tabela = new JTable(modelo);

                // Opcional: Personalizações adicionais (como seleção de linha inteira)
                tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                tabela.setRowSelectionAllowed(true);
                tabela.setColumnSelectionAllowed(false);

                // Adiciona a tabela a um JScrollPane
                JScrollPane painelRolagem = new JScrollPane(tabela);

                // Adiciona o painel de rolagem ao frame
                atrasoListar.add(painelRolagem, BorderLayout.CENTER);

                // Torna o frame visível
                atrasoListar.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
    }
}
