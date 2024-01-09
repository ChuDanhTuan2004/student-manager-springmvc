package org.example.project.repository;

import org.example.project.model.ObjectOfMe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOfMe extends JpaRepository<ObjectOfMe, Long> {
    Iterable<ObjectOfMe> findAllByNameContaining (String name);
}
