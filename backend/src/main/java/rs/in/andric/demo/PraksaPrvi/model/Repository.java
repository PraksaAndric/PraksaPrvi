package rs.in.andric.demo.PraksaPrvi.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name = "repository_table")
public class Repository {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String repositoryTitle;
    @Column
    private String repositoryIssues;
    @Column
    private String repositoryDescription;
    @Column
    private String repositoryGithubName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepositoryTitle() {
        return repositoryTitle;
    }

    public void setRepositoryTitle(String repositoryTitle) {
        this.repositoryTitle = repositoryTitle;
    }

    public String getRepositoryIssues() {
        return repositoryIssues;
    }

    public void setRepositoryIssues(String repositoryIssues) {
        this.repositoryIssues = repositoryIssues;
    }

    public String getRepositoryDescription() {
        return repositoryDescription;
    }

    public void setRepositoryDescription(String repositoryDescription) {
        this.repositoryDescription = repositoryDescription;
    }

    public String getRepositoryGithubName() {
        return repositoryGithubName;
    }

    public void setRepositoryGithubName(String repositoryGithubName) {
        this.repositoryGithubName = repositoryGithubName;
    }
}
