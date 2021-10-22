package model.account;

import java.io.Serializable;

public class Librarian extends User implements Serializable {

    public Librarian(String name, String id, int age, String nameAccount, String password) {
        super(name, id, age, nameAccount, password);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getNameAccount() {
        return super.getNameAccount();
    }

    @Override
    public void setNameAccount(String nameAccount) {
        super.setNameAccount(nameAccount);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
