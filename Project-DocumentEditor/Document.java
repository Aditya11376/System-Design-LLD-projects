import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<DocumentElement> elements;

    public Document(){
        this.elements = new ArrayList<>();
    }

    public void addElement(DocumentElement documentElement){
        elements.add(documentElement);
    }

    public List<DocumentElement> getElements(){
        return new ArrayList<>(elements);
    }

    public void removeElementByType(Class<?> type){
        elements.removeIf(e->type.isInstance(e));
    }

}
