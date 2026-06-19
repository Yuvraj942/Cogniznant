public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("--- Document Management System ---");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        System.out.println("----------------------------------");

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();

        System.out.println("----------------------------------");

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processNewDocument(); 
    }
}