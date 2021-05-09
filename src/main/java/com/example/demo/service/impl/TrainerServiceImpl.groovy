package com.example.demo.service.impl

import com.example.demo.domain.Trainer
import com.example.demo.repository.TrainerRepository
import com.example.demo.service.TrainerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TrainerServiceImpl implements TrainerService {

    @Autowired
    private final TrainerRepository trainerRepository

    @Override
    List<Trainer> findAll() {
        trainerRepository.findAll()
    }

    @Override
    Optional<Trainer> findById(int id) {
        trainerRepository.findById id
    }

    @Override
    Trainer save(Trainer trainer){
        Trainer nt = this.findById(trainer.id)?.get()
        if(nt){
            nt.setName(trainer.name)
            nt.setLevel(trainer.level)
            trainer = nt
        }
        trainerRepository.save(trainer)
    }
}