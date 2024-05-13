package org.example.application;

import org.example.model.entities.Reservation;
import org.example.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);

        int roomNumber = 0;
        Date checkIn, checkOut;
        try {
            System.out.println("Inico da reserva");
            System.out.print("Número do quarto: ");
            roomNumber = sc.nextInt();


            System.out.print("Data de check-in (dd/mm/aaaa): ");
            checkIn = simpleDateFormat.parse(sc.next());

            System.out.print("Data de check-out (dd/mm/aaaa): ");
            checkOut = simpleDateFormat.parse(sc.next());

            // se a data de checkout não for posterior a data de checkIn...

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Entre com os dados para atualizare a reserva");

            System.out.print("Data de check-in (dd/mm/aaaa): ");
            checkIn = simpleDateFormat.parse(sc.next());

            System.out.print("Data de check-out (dd/mm/aaaa): ");
            checkOut = simpleDateFormat.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);


            System.out.println(reservation);
        } catch (ParseException e) {
            System.out.println("Erro no envio das datas: " + e);
        } catch (DomainException e) {
            System.out.println("Erro ao registrar a reserva: " + e.getMessage());

        } catch (RuntimeException e){
            System.out.println("Ocorreu um erro inesperado >> "+ e);
        }


        sc.close();
    }
}