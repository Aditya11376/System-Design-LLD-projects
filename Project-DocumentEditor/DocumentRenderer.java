import java.util.List;

public class DocumentRenderer {

    private Document doc;

    public DocumentRenderer(Document doc){
        this.doc = doc;
    }

    public String render(){

        List<DocumentElement> list = doc.getElements();
        StringBuilder res = new StringBuilder();

        for(DocumentElement documentElement : list){
            res.append(documentElement.render());
        }

        return res.toString();
    }

}
