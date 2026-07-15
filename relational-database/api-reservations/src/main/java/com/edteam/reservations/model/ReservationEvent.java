package com.edteam.reservations.model; // PAQUETE SEGÚN TU ESTRUCTURA

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ReservationEvent {
    private final String id;
    private final String passengerName;
    private final Double price;
    private final List<String> emails;

    public ReservationEvent(String id, String passengerName, Double price, List<String> emails) {
        this.id = id;
        this.passengerName = passengerName;
        this.price = price;
        this.emails = (emails != null) ? new ArrayList<>(emails) : new ArrayList<>();
    }

    public String getId() { return id; }
    public String getPassengerName() { return passengerName; }
    public Double getPrice() { return price; }
    public List<String> getEmails() { return Collections.unmodifiableList(emails); }

    @Override
    public String toString() {
        return "Reserva [ID=" + id + ", Pasajero=" + passengerName + ", Precio=" + price + "]";
    }
}