package CRUD;

import Model.Subscribers;

import java.util.ArrayList;
import java.util.List;

public class SubscribersCrudOperations implements CrudOperations<Subscribers> {

    private List<Subscribers> subscribersList = new ArrayList<>();

    @Override
    public List<Subscribers> findAll() {
        return subscribersList;
    }

    @Override
    public List<Subscribers> saveAll(List<Subscribers> toSave) {
        subscribersList.addAll(toSave);
        return toSave;
    }

    @Override
    public Subscribers save(Subscribers toSave) {
        if (!subscribersList.contains(toSave)) {
            subscribersList.add(toSave);
        } else {
            int index = subscribersList.indexOf(toSave);
            subscribersList.set(index, toSave);
        }
        return toSave;
    }

    @Override
    public Subscribers delete(Subscribers toDelete) {
        subscribersList.remove(toDelete);
        return toDelete;
    }
}