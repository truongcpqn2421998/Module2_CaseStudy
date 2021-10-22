package model.account;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected String id;
    protected int age;
    protected String nameAccount;
    protected String password;

    public User(String name, String id, int age, String nameAccount, String password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.nameAccount = nameAccount;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", nameAccount='" + nameAccount + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
