package org.example.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation implements Serializable {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

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


    public long duration() {
        // pega a diferença nas datas em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        // converter o milisegundos em dias
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now))    return "Erro na atualização ! As datas de atualização devem ser futuras e não datas passadas";
        if (!checkOut.after(checkIn))                       return "Erro na reserva ! Data de saída(check-out) não pode ser inferir a data de entrada(check-in)";

        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    @Override
    public String toString() {
        return "Reserva: Quarto= " + roomNumber + ", check-in= " + simpleDateFormat.format(checkIn) + ", check-out= " + simpleDateFormat.format(checkOut) + ", " + duration() + " noites";
    }
}
