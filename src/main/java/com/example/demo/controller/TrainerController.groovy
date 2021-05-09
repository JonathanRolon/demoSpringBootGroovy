package com.example.demo.controller

import com.example.demo.domain.Trainer
import com.example.demo.service.TrainerService
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @RequestMapping(value='/edit', method=RequestMethod.POST)
    public ModelAndView edit(Model model, @ModelAttribute(value="trainer") Trainer tr) {
        try {
            Trainer thisTrainer = trainerService.save(tr)
            model.addAttribute("trainer", trainerService.findById(thisTrainer.getId()))
            new ModelAndView('views/Trainer/trainer', [trainer: trainerService.findById(thisTrainer.getId())])

        } catch (Exception ex) {
            new ModelAndView('views/Trainer/error')
        }

    }

    @PostMapping("/add")
    public ModelAndView addTrainer(Model model, @ModelAttribute('trainer') Trainer tr) {
        try {
            Trainer newTrainer = trainerService.save(tr)
            model.addAttribute("trainer", trainerService.findById(newTrainer.getId()))
            new ModelAndView('views/Trainer/trainer', [trainer: trainerService.findById(newTrainer.getId())])

        } catch (Exception ex) {
            // log exception first,
            // then show error
            new ModelAndView('views/Trainer/trainers')
        }

    }

    /*@GetMapping("/all")
    ModelAndView showAll(Model model){
        model.addAttribute("trainers", trainerService.findAll())
        return new ModelAndView ("home", model)
    }*/

    @GetMapping("/")
    ModelAndView showAll(Model model) {
        model.addAttribute("trainer", new Trainer())
        new ModelAndView('views/Trainer/trainers', [trainers: trainerService.findAll()])
    }

    /*@RequestMapping(value = '/{id}/pokemon', method = RequestMethod.GET)
    List<Trainer> findCaughtPokemon(@PathVariable('id') int id) {
        wildPokemonService.findByTrainer id
    }*/

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    ModelAndView findById(@PathVariable('id') int id, Model model) {

        model.addAttribute("trainer", trainerService.findById(id))
        new ModelAndView('views/Trainer/trainer', [trainer: trainerService.findById(id)])
    }

    /**######### Validaciones ######**/
    /*@Override
    def validate(data){
        errors = []
        if(data.get(name)["value"] != "form1")
            errors.add("name not allowed")

        return errors
    }*/
}