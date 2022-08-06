package com.phalaenopsis.phalaenopsis.domain;

import javax.persistence.*;
import java.util.List;
@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long Id;
    public String Name;
    public String Description;
    public String Url;
    @ElementCollection // 1
    @CollectionTable(name = "Keyword_List", joinColumns = @JoinColumn(name = "Id")) // 2
    @Column(name = "keywords") // 3
    List<String> keywords;

    public Topic(String name, String description, String url, List<String> keywords) {
        this.Name = name;
        this.Description = description;
        this.Url = url;
        this.keywords = keywords;
    }

    public Topic() {

    }
}
