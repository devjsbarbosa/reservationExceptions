package org.example.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation implements Serializable {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation () {}

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }


    public long duration(){
        // pega a diferença nas datas em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        // converter o milisegundos em dias
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout){

    }

    @Override
    public String toString() {
        return "Reserva: Quarto " + roomNumber + ", check-in: " + checkIn + ", check-out: " + checkOut + duration();
    }
}
