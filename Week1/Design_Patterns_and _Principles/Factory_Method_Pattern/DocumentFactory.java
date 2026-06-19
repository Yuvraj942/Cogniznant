public abstract class DocumentFactory {
    public abstract Document createDocument();
    
    public void processNewDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }
}