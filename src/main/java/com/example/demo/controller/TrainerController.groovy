package com.example.demo.controller

import com.example.demo.domain.Trainer
import com.example.demo.service.TrainerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping('/trainers')
class TrainerController {

    @Autowired
    private final TrainerService trainerService

    @RequestMapping(method = RequestMethod.GET)
    List<Trainer> findAll() {
        trainerService.findAll()
    }

    /*@GetMapping("/all")
    ModelAndView showAll(Model model){
        model.addAttribute("trainers", trainerService.findAll())
        return new ModelAndView ("home", model)
    }*/

    @GetMapping("/all")
    ModelAndView showAll(Model model) {
        /*model.addAttribute("trainers", trainerService.findAll())*/
        new ModelAndView('views/Trainer/trainers', [trainers: trainerService.findAll()])
        /* return new ModelAndView ("home", model)*/
    }

    /*@RequestMapping(value = '/{id}/pokemon', method = RequestMethod.GET)
    List<Trainer> findCaughtPokemon(@PathVariable('id') int id) {
        wildPokemonService.findByTrainer id
    }*/

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    Optional<Trainer> findById(@PathVariable('id') int id) {
        trainerService.findById id
        //asdfadsf
    }
}