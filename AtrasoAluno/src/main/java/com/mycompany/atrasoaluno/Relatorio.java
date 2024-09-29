package com.mycompany.atrasoaluno;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

/**
 *
 * @author faart
 */
public class Relatorio {

    public boolean periodoTempo(String periodoInit, String periodoFin, String atraso) throws ParseException {

        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

        String init[] = periodoInit.split("-");
        String fin[] = periodoFin.split("-");
        String atrasoV[] = atraso.split("-");

        String dataInitS = init[2] + "/" + init[1] + "/" + init[0];
        String dataFinS = fin[2] + "/" + fin[1] + "/" + fin[0];
        String atrasoS = atrasoV[2] + "/" + atrasoV[1] + "/" + atrasoV[0];

        Date dataInit = sdt.parse(dataInitS);
        Date dataFin = sdt.parse(dataFinS);
        Date dataAtraso = sdt.parse(atrasoS);

        System.out.println(dataInit + " - " + dataAtraso + " - " + dataFin);

        if (dataFin.after(dataAtraso) && dataInit.before(dataAtraso)) {
            System.out.println("True");
            return true;
        }
        return false;
    }

    //Retorna uma String com relatório formatado
    public String relatorioString(Atraso atraso, String periodoInit, String periodoFin) throws SQLException, ParseException {
        String retorno = "";
        if (periodoTempo(periodoInit, periodoFin, atraso.getData())) {
            retorno = "Aluno: " + atraso.getAluno().getNome()
                    + "\nNumº de Faltas: " + atraso.getNumAtrasoAluno()
                    + "\nTurma: " + atraso.getAluno().getTurmaNome()
                    + "\nProfessor: " + atraso.getFuncionario().getNome()
                    + "\nPeríodo: " + periodoInit + " - " + periodoFin;
        }
        return retorno;
    }

    public void relatorioPDF(ArrayList<Atraso> atraso, String periodoInit, String periodoFin) throws DocumentException, FileNotFoundException, SQLException, ParseException {
        Document document = new Document();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormat.format(currentDate);

        PdfWriter.getInstance(document, new FileOutputStream("relatorio" + currentDateTime + ".pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(5);
        addHeader(table);
        addLinha(table, atraso, periodoInit, periodoFin);

        document.add(new Paragraph("Tabela de faltas do aluno", font));
        document.add(new Paragraph("\n"));
        document.add(table);
        document.close();
    }

    public void addHeader(PdfPTable table) {
        Stream.of("Aluno", "Atrasos", "Turma", "Professor", "Período")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.ORANGE);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    public void addLinha(PdfPTable table, ArrayList<Atraso> array, String periodoInit, String periodoFin) throws SQLException, ParseException {
        for (Atraso a : array) {
            if (periodoTempo(periodoInit, periodoFin, a.getData())) {
                table.addCell(a.getAluno().getNome());
                table.addCell(Integer.toString(a.getNumAtrasoAluno()));
                table.addCell(a.getAluno().getTurmaNome());
                table.addCell(a.getFuncionario().getNome());
                table.addCell(periodoInit + "   " + periodoFin);
            }
        }
    }
}
