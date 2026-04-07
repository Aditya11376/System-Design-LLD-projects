public class Client {
    public static void main(String[] args) {

        Document document = new Document();
        Persistence persistence =  new FileStorage();

        DocumentRenderer renderer  = new DocumentRenderer(document);
        DocumentEditor editor = new DocumentEditor(document,persistence);

        editor.addImage("Image1.jpg");
        editor.addText("Text1");
        editor.addNewLine();
        editor.addText("Text2");
        editor.addTabSpace();
        editor.addNewLine();
        editor.addText("Text3");
        editor.addTabSpace();
        editor.addNewLine();
        editor.addImage("Image2.png");
        editor.addText("This is a document page");
        System.out.println();
        System.out.println(renderer.render());
//        editor.saveDocument();
        System.out.println();
        editor.removeElement(TextElement.class);
        editor.removeElement(NewLineElement.class);
        System.out.println(renderer.render());
        editor.saveDocument();
    }
}
