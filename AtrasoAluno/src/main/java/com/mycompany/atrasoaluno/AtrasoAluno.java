/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atrasoaluno;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

/**
 *
 * @author faart
 */
public class AtrasoAluno {

    public static void main(String[] args) throws SQLException, DocumentException, FileNotFoundException, ParseException {

        ConDB condb = new ConDB();
        Relatorio rel = new Relatorio();
        
        condb.returnAtrasos();
        rel.relatorioPDF(condb.arrayAtraso, "2023-09-08", "2023-12-23");
    }
}
