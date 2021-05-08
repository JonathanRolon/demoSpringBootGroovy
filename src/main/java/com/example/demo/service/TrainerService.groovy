package com.example.demo.service

import com.example.demo.domain.Trainer

interface TrainerService {

    List<Trainer> findAll()

    Optional<Trainer> findById(int id)
}
