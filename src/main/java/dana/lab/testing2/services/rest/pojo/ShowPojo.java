package dana.lab.testing2.services.rest.pojo;

import lombok.Data;

@Data
public class ShowPojo {

    private String documentPartType;

    private String url;

    public ShowPojo() {
    }

    public ShowPojo(String documentPartType, String url) {
        this.documentPartType = documentPartType;
        this.url = url;
    }
}
