package model.book;

import java.io.Serializable;

public abstract class Book implements Serializable {
    protected String title;
    protected String category;
    protected String code;
    protected boolean status=true;


    public Book(String title, String category, String code, boolean status) {
        this.title = title;
        this.category = category;
        this.code = code;
        this.status = status;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
