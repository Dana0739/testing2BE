package dana.lab.testing2.services.rest;

import lombok.Data;

@Data
public class ShowDTO {

    private String content;

    private String url;

    public ShowDTO() {
    }

    public ShowDTO(String content, String url) {
        this.content = content;
        this.url = url;
    }
}
