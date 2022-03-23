package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController controller;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        controller = new VetController(vetService);

        vetService.save(new Vet(1L, "joe", "buck", null));
        vetService.save(new Vet(2L, "Jim", "Smith", null));
    }

    @Test
    void testListVets() {
        Model model = new ModelMapImpl();
        assertEquals("vets/index", controller.listVets(model));

        Set modelAttribute = (Set)((ModelMapImpl)model).getMap().get("vets");

        assertEquals(modelAttribute.size(), 2);
    }
}