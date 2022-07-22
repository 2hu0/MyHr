package com.vhr.model.bean;

public class Role {
    private Integer id;

    private String name;

    private String nameZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getnameZh() {
        return nameZh;
    }

    public void setnameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }
}