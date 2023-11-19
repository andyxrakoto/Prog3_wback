package CRUD;

import java.util.Objects;

public class Author {
    private String authorName;

    public Author(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;
        return authorName.equals(author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }
}