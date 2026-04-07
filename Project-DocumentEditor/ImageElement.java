public class ImageElement implements DocumentElement{

    private String path;

    public ImageElement(String path){
        this.path = path;
    }

    @Override
    public String render() {
        return " [Image: " + path + "] ";
    }

}
