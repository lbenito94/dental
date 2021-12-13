package com.dental.util;

import com.dental.models.entity.Paciente;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("/views/pacientes/listar")
public class ListarPacientePdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Paciente> listadoPacientes = (List<Paciente>) model.get("pacientes");

        /*Fuentes, tamanios y colores para cada seccion */
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLACK);
        Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);

        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(-20,-20,40,20);
        document.open();
        PdfPCell celda = null;

        /* Tabla para el titulo del PDF */
        PdfPTable tablaTitulo = new PdfPTable(1);

        celda = new PdfPCell(new Phrase("LISTADO GENERAL DE PACIENTES", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(Color.ORANGE);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(20);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        /*Tabla para mostrar listado de pacientes*/
        PdfPTable tablaPacientes = new PdfPTable(7);
        tablaPacientes.setWidths(new float[]{0.8f,1.5f,1.5f,1.5f,1.5f,2f,1.5f});

        celda = new PdfPCell(new Phrase("ID",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Tipo Documento",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Numero Documento",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Apellido Paterno",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Apellido Materno",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Nombres",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Numero Celular",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPacientes.addCell(celda);

        /* Bucle for, mostrar todos los datos de los pacientes*/

        for (Paciente paciente : listadoPacientes){
            celda= new PdfPCell(new Phrase(paciente.getId().toString(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);

            celda= new PdfPCell(new Phrase(paciente.getTipodocumento(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);

            celda= new PdfPCell(new Phrase(paciente.getNumerodocumento(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);

            celda= new PdfPCell(new Phrase(paciente.getApellidopaterno(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);

            celda= new PdfPCell(new Phrase(paciente.getApellidomaterno(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);

            celda= new PdfPCell(new Phrase(paciente.getNombres(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);

            celda= new PdfPCell(new Phrase(paciente.getNumerocelular(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaPacientes.addCell(celda);
        }
        /*
        listadoPacientes.forEach(paciente -> {
            tablaPacientes.addCell(paciente.getId().toString());
            tablaPacientes.addCell(paciente.getTipodocumento());
            tablaPacientes.addCell(paciente.getNumerodocumento());
            tablaPacientes.addCell(paciente.getApellidopaterno());
            tablaPacientes.addCell(paciente.getApellidomaterno());
            tablaPacientes.addCell(paciente.getNombres());
            tablaPacientes.addCell(paciente.getNumerocelular());
        }); */

        /* Anexamos las tablas al documento */
        document.add(tablaTitulo);
        document.add(tablaPacientes);
    }
}
