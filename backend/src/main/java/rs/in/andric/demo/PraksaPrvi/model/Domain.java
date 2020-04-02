package rs.in.andric.demo.PraksaPrvi.model;

import javax.persistence.*;

@Entity
@Table(name = "domain_table")
public class Domain {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column
    private String param_title;
    @Column
    private String param_date;
    @Column
    private String param_content;
    @Column
    private String param_container;

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

    public String getParam_title() {
        return param_title;
    }

    public void setParam_title(String param_title) {
        this.param_title = param_title;
    }

    public String getParam_date() {
        return param_date;
    }

    public void setParam_date(String param_date) {
        this.param_date = param_date;
    }

    public String getParam_content() {
        return param_content;
    }

    public void setParam_content(String param_content) {
        this.param_content = param_content;
    }

    public String getParam_container() {
        return param_container;
    }

    public void setParam_container(String param_container) {
        this.param_container = param_container;
    }
}
