package by.atmm.javaspringtestproject.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-24
 */

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 15)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    List<Child> children = new ArrayList<>();

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChildToSection(Child child) {
        children.add(child);
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

    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}