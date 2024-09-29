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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        mainMenu = new JPanel(new GridLayout(1, 3, 10, 10));
        mainMenu.setBackground(Color.yellow);

        /*Botôes-----------------------------------------------------------------------------------------------------*/
        alunoMB = new JButton("Alunos");
        alunoMB.addActionListener(this);
        funcionarioMB = new JButton("Turmas");
        funcionarioMB.addActionListener(this);
        turmaMB = new JButton("Funcionarios");
        turmaMB.addActionListener(this);

        /*Montar o Menu Principal------------------------------------------------------------------------------------*/
        mainMenu.add(alunoMB);
        mainMenu.add(funcionarioMB);
        mainMenu.add(turmaMB);

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

        confUpdAluno = new JButton("Seleciona livro");
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

        alunoUpdConf = new JButton("Confirmar");
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

        selectMembro = new JPanel(new GridLayout(1, 2, 20, 20));
        selectMembro.setBackground(Color.LIGHT_GRAY);
        JLabel listarMembroTexto = new JLabel("Membros:");
        selectMembro.add(listarMembroTexto);
        selectMembro.add(boxFuncionarioList);
        membroListConf = new JButton("Selecionar");
        membroListConf.addActionListener(this);
        selectMembro.add(membroListConf);
        membroListar.add(selectMembro, BorderLayout.NORTH);

        membroListar.add(listarMembroTextoEdit, BorderLayout.CENTER);

        membroCL.add(membroListar, "listarMembro");

        /*ADICIONAR LIVRO AO FRAME PRINCIPAL-----------------------------------------------------------------------------------------------------*/
        membroFrame.add(membroMenu, BorderLayout.NORTH);
        membroFrame.add(membroCL, BorderLayout.CENTER);
        placeHolder.add(membroFrame, "membros");
        /*------------------------------------------------------------------------------------------------------------------------------------------------*/
        placeHolder.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    public static void main(String[] args) {
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
                
                Aluno aluno = new Aluno(nomeAlunoAdd.getText(), telefoneAlunoAdd.getText(), emailAlunoAdd.getText(), condb.getTurmaId(turmaAlunoAdd.getSelectedObjects().toString()));
                
                nomeAlunoAdd.setText("");
                telefoneAlunoAdd.setText("");
                emailAlunoAdd.setText("");
            }
            if (e.getSource() == alunoMenuDel) {
                
            }
            if (e.getSource() == confUpdAluno) {
                
            }
            if (e.getSource() == alunoUpdConf) {

            }

            /*BOTÕES DO MENU DE AUTOR*/
            if (e.getSource() == autorMenuAdd) {

            }
            if (e.getSource() == autorAddConf) {

            }
            if (e.getSource() == autorMenuDel) {

            }
            if (e.getSource() == autorDelConf) {

            }
            if (e.getSource() == autorMenuUpd) {

            }
            if (e.getSource() == autorUpdConf) {

            }
            if (e.getSource() == autorMenuListar) {

            }
            if (e.getSource() == autorListConf) {

            }
            /*BOTÕES DO MENU DE MEMBROS*/
            if (e.getSource() == membroMenuAdd) {

            }
            if (e.getSource() == membroAddConf) {

            }
            if (e.getSource() == membroMenuDel) {

            }
            if (e.getSource() == membroDelConf) {

            }
            if (e.getSource() == membroMenuUpd) {

            }
            if (e.getSource() == confUpdMembro) {

            }
            if (e.getSource() == membroUpdConf) {

            }
            if (e.getSource() == membroMenuListar) {

            }
            if (e.getSource() == membroListConf) {

            }
        } catch (Exception ex) {
        }
    }
}
