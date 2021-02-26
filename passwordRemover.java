import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
public class passwordRemover {
    public static void main(String[] args) {
        String sourceFile="file path of the source pdf file";
        String outFile="file path of the out pdf file";
        try {
            PdfReader.unethicalreading=true;
            PdfReader pdfReader = new PdfReader(sourceFile);
            Document document = new Document();
            FileOutputStream out = new FileOutputStream(outFile);
            PdfWriter pdfWriter = PdfWriter.getInstance(document,out);
            document.open();
            PdfContentByte cb = pdfWriter.getDirectContent();
            int pageOfCurrentReaderPDF=0;
            int pageNumber=pdfReader.getNumberOfPages();
            System.out.println(pageNumber);
            while (pageOfCurrentReaderPDF < pageNumber) {
                document.newPage();
                pageOfCurrentReaderPDF++;
                PdfImportedPage page = pdfWriter.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
                cb.addTemplate(page, 0, 0);
            }
            out.flush();
            document.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}