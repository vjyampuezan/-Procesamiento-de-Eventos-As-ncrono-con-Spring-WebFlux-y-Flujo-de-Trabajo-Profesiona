package com.edteam.reservations.util;

import com.edteam.reservations.model.ReservationEvent;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReservationFilters {
    // Actividad 2: Predicate para validar precio y correos
    public static final Predicate<ReservationEvent> isValidReservation =
            event -> event.getPrice() > 0 && !event.getEmails().isEmpty();

    // Actividad 2: Consumer para imprimir en consola
    public static final Consumer<ReservationEvent> logEvent =
            event -> System.out.println("Procesando Evento: " + event);
}