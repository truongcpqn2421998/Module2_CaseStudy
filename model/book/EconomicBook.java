package model.book;

import java.io.Serializable;

public class EconomicBook extends Book implements Serializable {

    public EconomicBook(String title, String category, String code, boolean status) {
        super(title, category, code, status);
    }

    public EconomicBook() {
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public void setCategory(String category) {
        super.setCategory(category);
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    @Override
    public void setCode(String code) {
        super.setCode(code);
    }

    @Override
    public boolean isStatus() {
        return super.isStatus();
    }

    @Override
    public void setStatus(boolean status) {
        super.setStatus(status);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
