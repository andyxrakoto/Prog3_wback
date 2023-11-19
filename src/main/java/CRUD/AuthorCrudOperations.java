package CRUD;

import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {
    private List<Author> authors = new ArrayList<>();

    @Override
    public List<Author> findAll() {
        return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        authors.addAll(toSave);
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        if (!authors.contains(toSave)) {
            authors.add(toSave);
        } else {
            int index = authors.indexOf(toSave);
            authors.set(index, toSave);
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        authors.remove(toDelete);
        return toDelete;
    }
}

