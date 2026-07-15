package com.edteam.reservations.controller; // MISMO PAQUETE QUE TU CONTROLADOR ORIGINAL

import com.edteam.reservations.model.ReservationEvent;
import com.edteam.reservations.util.ReservationFilters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.util.List;

@RestController
@RequestMapping("/api/reservations") // Nueva ruta para no chocar con la anterior
public class ReactiveReservationController {

    @GetMapping(value = "/stream", produces = "application/json")
    public Flux<ReservationEvent> getReservationStream() {
        // Generamos las 5 reservas en memoria (Actividad 3)
        ReservationEvent r1 = new ReservationEvent("1", "Juan", 150.0, List.of("juan@mail.com"));
        ReservationEvent r2 = new ReservationEvent("2", "Maria", 200.0, List.of("maria@mail.com"));
        ReservationEvent r3 = new ReservationEvent("3", "Pedro", 0.0, List.of());
        ReservationEvent r4 = new ReservationEvent("4", "Ana", -10.0, List.of("ana@mail.com"));
        ReservationEvent r5 = new ReservationEvent("5", "Luis", 300.0, List.of("luis@mail.com"));

        ReservationEvent defaultReservation = new ReservationEvent("0", "Sistema", 0.0, List.of("admin@airline.com"));

        return Flux.just(r1, r2, r3, r4, r5) // FLUX.JUST() COMO PIDE EL INGENIERO
                .filter(ReservationFilters.isValidReservation)
                .doOnNext(ReservationFilters.logEvent)
                .defaultIfEmpty(defaultReservation);
    }
}