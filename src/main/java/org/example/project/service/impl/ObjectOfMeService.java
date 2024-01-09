package org.example.project.service.impl;

import org.example.project.model.ObjectOfMe;
import org.example.project.repository.RepositoryOfMe;
import org.example.project.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObjectOfMeService implements IObjectService {
    @Autowired
    RepositoryOfMe repositoryOfMe;

    @Override
    public Iterable<ObjectOfMe> findAll() {
        return repositoryOfMe.findAll();
    }

    @Override
    public Optional<ObjectOfMe> findById(Long id) {
        return repositoryOfMe.findById(id);
    }

    @Override
    public void save(ObjectOfMe objectOfMe) {
        repositoryOfMe.save(objectOfMe);
    }

    @Override
    public void remove(Long id) {
        repositoryOfMe.deleteById(id);
    }

    @Override
    public Iterable<ObjectOfMe> findByName(String name) {
        return repositoryOfMe.findAllByNameContaining(name);
    }
}
