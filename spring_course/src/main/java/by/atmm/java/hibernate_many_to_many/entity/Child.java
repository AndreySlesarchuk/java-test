package by.atmm.java.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-24
 */

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "age")
    private Integer age;

    public List<Section> getSections() {
        return sections;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    List<Section> sections = new ArrayList<>();

    public Child() {
    }

    public Child(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void addSectionToChild(Section section) {
        sections.add(section);
    }

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
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}