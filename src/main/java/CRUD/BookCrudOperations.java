package CRUD;

import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        books.addAll(toSave);
        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        if (!books.contains(toSave)) {
            books.add(toSave);
        } else {
            int index = books.indexOf(toSave);
            books.set(index, toSave);
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        books.remove(toDelete);
        return toDelete;
    }
}