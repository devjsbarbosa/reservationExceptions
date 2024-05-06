package org.example.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation () {}

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public double duration(){
        return 0;
    }

    public void updateDates(Date checkin, Date checkout){

    }

    @Override
    public String toString() {
        return "Reserva: Quarto " + roomNumber + ", check-in: " + checkin + ", check-out: " + checkout + duration();
    }
}
