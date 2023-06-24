//package com.koshelev.BookShelf.models;
//
//import javax.persistence.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "roles")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column
//    private String name;
//
//    @Enumerated(EnumType.STRING)
//    @Column
//    private Status status;
//
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
//
//    public Role() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//}
