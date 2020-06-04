package rs.in.andric.demo.PraksaPrvi.model;

import javax.persistence.*;

@Entity
@Table(name = "domain")
public class Domain {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column
    private String title;
    @Column
    private String date;
    @Column
    private String content;
    @Column
    private String container;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String param_title) {
        this.title = param_title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String param_date) {
        this.date = param_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String param_content) {
        this.content = param_content;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String param_container) {
        this.container = param_container;
    }
}
