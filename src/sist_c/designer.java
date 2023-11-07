/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sist_c;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Shinespark
 */
public class designer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // step 1: creation of a document-object  and get the data to the database
        
        raw_diary_book_moves dbm = new raw_diary_book_moves();
        List<obj_dbm> mv_ = new ArrayList<>();
        mv_ = dbm.JOIN();
        Document document = new Document();

        try {
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("Transactions.pdf"));

            // step 3: we open the document
            document.open();
            
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            //--------------------- pagina 1 --------------------------
            g.setColor(Color.DARK_GRAY);
            g.fillRect(1, 80, 600, 50);    
            
                        
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);

            g.setColor(Color.BLUE);
            g.drawString("Reporte de movimientos", 40, 50);
            
            Font font3 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 11);
            g.setFont(font3);
            g.setColor(Color.black);
            g.drawString("Movimientos individuales registrados en el libro diario", 40, 70);
            
           //ImageIcon img2 = new ImageIcon(getClass().getResource("imagenes/java-duke-guitar.png"));
            //g.drawImage(img2.getImage(), 230, 220, 250, 250, null);
            
            g.drawRect(490, 0, 80, 80);    
           int X = 50;
           int Y = 140;
           int page = 1;
           
           int row = 1;
           int row_size = 35;
           
           int col_size1 = 50;
           int col_size2 = 175;
           int col_size3 = 150;
           int col_size4 = 55;
           int col_size5 = 55;
            g.setColor(Color.BLACK);
            Font font4 = new Font("Tahoma", Font.BOLD, 12);
            g.setFont(font4);
            int max_1 = 10;
            int max__ = 15;
            int cmpx = 4;
            int cmpy = 12;
           
            // title
            g.drawRect(X, row * row_size + Y, col_size1, row_size);
            g.drawRect(X + col_size1, row * row_size + Y, col_size2, row_size);
            g.drawRect(X + col_size1 + col_size2, row * row_size + Y, col_size3, row_size);
            g.drawRect(X + col_size1 + col_size2 + col_size3, row * row_size + Y, col_size4, row_size);
            g.drawRect(X + col_size1 + col_size2 + col_size3 + col_size4, row * row_size + Y, col_size5, row_size);
            
            g.drawString("id", X + cmpx, row * row_size + Y + row_size - cmpy );
            g.drawString("Fecha", X + col_size1 + cmpx, row * row_size + Y + row_size - cmpy );
            g.drawString("Descripcion", X + col_size1 + col_size2 + cmpx, row * row_size + Y + row_size - cmpy );
            g.drawString("Tipo", X + col_size1 + col_size2 + col_size3 + cmpx, row * row_size + Y + row_size - cmpy );
            g.drawString("Monto", X + col_size1 + col_size2 + col_size3 + col_size4 + cmpx, row * row_size + Y + row_size - cmpy );
            
            Font font2 = new Font("Tahoma", Font.PLAIN, 12);
            g.setFont(font2);
            
            for(obj_dbm item: mv_){
                row++;
                if((row > max_1 && page == 1) || row > max__ && page != 1){
                    document.newPage();
                    page++;
                    row = 1;
                }
                if(page != 1){
                    Y = 20;
                }
                g.drawRect(X, row * row_size + Y, col_size1, row_size);
                g.drawRect(X + col_size1, row * row_size + Y, col_size2, row_size);
                g.drawRect(X + col_size1 + col_size2, row * row_size + Y, col_size3, row_size);
                g.drawRect(X + col_size1 + col_size2 + col_size3, row * row_size + Y, col_size4, row_size);
                g.drawRect(X + col_size1 + col_size2 + col_size3 + col_size4, row * row_size + Y, col_size5, row_size);

                g.drawString(String.valueOf(item.getId()), X + cmpx, row * row_size + Y + row_size - cmpy );
                g.drawString(String.valueOf(item.getDate()), X + col_size1 + cmpx, row * row_size + Y + row_size - cmpy );
                g.drawString(String.valueOf(item.getDescription()), X + col_size1 + col_size2 + cmpx, row * row_size + Y + row_size - cmpy );
                g.drawString(String.valueOf(item.getAcount_type()), X + col_size1 + col_size2 + col_size3 + cmpx, row * row_size + Y + row_size - cmpy );
                g.drawString(String.valueOf(item.getAmount()), X + col_size1 + col_size2 + col_size3 + col_size4 + cmpx, row * row_size + Y + row_size - cmpy );

            }
            
            //draw list first page
            
            
            //document.newPage();
            //--------------------- pagina 2 --------------------------
            
            //g.setColor(Color.GREEN);
            //g.drawLine(1, 1, 200, 200);

            //g.setColor(Color.BLUE);
            //g.drawRect(200, 200, 300, 300);
            
            //ImageIcon img2 = new ImageIcon(getClass().getResource("imagenes/java-duke-guitar.png"));
            //g.drawImage(img2.getImage(), 230, 220, 250, 250, null);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        JOptionPane.showMessageDialog(null, 
                "Se creo el archivo 'Transacciones.pdf' en la carpeta del proyecto");
    }
    
}
