package dana.lab.testing2.services.rest.pojo;

import lombok.Data;

@Data
public class ShowPojo {

    private String content;

    private String url;

    public ShowPojo() {
    }

    public ShowPojo(String content, String url) {
        this.content = content;
        this.url = url;
    }
}
