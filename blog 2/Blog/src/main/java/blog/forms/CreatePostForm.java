package blog.forms;

import javax.validation.constraints.NotNull;

public class CreatePostForm {

    @NotNull
    private String title;

    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
