package ua.mkorniie.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catalogue", schema = "mydb")
public class CatalogueEntity {
    private int id;
    private String index;
    private String title;
    private String cover;
    private Language language;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "index")
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "language")
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogueEntity that = (CatalogueEntity) o;
        return id == that.id &&
                Objects.equals(index, that.index) &&
                Objects.equals(title, that.title) &&
                Objects.equals(cover, that.cover) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, title, cover, language);
    }
}
