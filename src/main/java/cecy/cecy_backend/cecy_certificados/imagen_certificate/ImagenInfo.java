package cecy.cecy_backend.cecy_certificados.imagen_certificate;


public class ImagenInfo {
    private String name;
    private String url;

    public ImagenInfo() {
    }

    public ImagenInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}