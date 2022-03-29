package editor;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileSave {
  public FileSave(JFileChooser chooser, JTextArea textarea) {
    FileNameExtensionFilter txt = new FileNameExtensionFilter("Text document(*.txt)", "txt");
    FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF document(*.pdf)", "pdf");
    chooser.setFileFilter(txt);
    chooser.setFileFilter(pdf);
    chooser.setDialogTitle("Save as");
    chooser.showSaveDialog(null);
    chooser.setVisible(true);
    try {
      String select = chooser.getSelectedFile().getPath();
      if (chooser.getFileFilter() == txt) {
        PrintStream ps = new PrintStream(select + ".txt");
        ps.write(textarea.getText().getBytes());
        ps.flush();
        ps.close();

      } else if (chooser.getFileFilter() == pdf) {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(select + ".pdf"));
        document.open();
        document.add(new Paragraph(textarea.getText()));
        document.close();
      }
    } catch (Exception e1) {
    }
  }
}
