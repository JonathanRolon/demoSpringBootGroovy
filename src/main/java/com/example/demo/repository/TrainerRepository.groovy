package com.example.demo.repository

import com.example.demo.domain.Trainer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    List<Trainer> findAll()

    Optional<Trainer> findById( Integer id)

    Trainer save(Trainer trainer)

    void deleteById(Integer id);
}
