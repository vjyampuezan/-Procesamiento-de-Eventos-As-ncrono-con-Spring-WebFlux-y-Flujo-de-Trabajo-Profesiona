package com.edteam.reservations.util; // PAQUETE NUEVO PERO DENTRO DE TU ESTRUCTURA

import com.edteam.reservations.model.ReservationEvent;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReservationFilters {
    public static final Predicate<ReservationEvent> isValidReservation =
            event -> event.getPrice() > 0 && !event.getEmails().isEmpty();

    public static final Consumer<ReservationEvent> logEvent =
            event -> System.out.println("Procesando Evento: " + event);
}