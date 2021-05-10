package com.example.demo.service

import com.example.demo.domain.Trainer

interface TrainerService {

    List<Trainer> findAll()

    Optional<Trainer> findById(int id)

    Trainer create(Trainer trainer)

    Trainer update(Trainer trainer)

    void deleteById(Integer id)
}
