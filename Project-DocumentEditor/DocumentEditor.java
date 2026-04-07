public class DocumentEditor {

    private Document document;
    private Persistence persistence;

    public DocumentEditor(Document document, Persistence persistence) {
        this.document = document;
        this.persistence = persistence;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String path){
        document.addElement(new ImageElement(path));
    }

    public void addTabSpace(){
        document.addElement(new TabSpaceElement());
    }

    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public void saveDocument(){
        DocumentRenderer documentRenderer = new DocumentRenderer(document);
        String output = documentRenderer.render();
        persistence.save(output);
    }

    public void removeElement(Class<? extends DocumentElement> type){
        document.removeElementByType(type);
    }

}
