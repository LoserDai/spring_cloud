package com.df.pojo;

/**
 * @author Loser
 * @date 2021年11月12日 14:39
 */
public class User {
    private Integer id;
    private String nam;
    private Integer age;

    public User(Integer id, String nam, Integer age) {
        this.id = id;
        this.nam = nam;
        this.age = age;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
