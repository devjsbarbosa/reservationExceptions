package org.example.application;

import org.example.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);

        int roomNumber = 0;
        Date checkIn, checkOut;
        System.out.println("Inico da reserva");
        System.out.print("Número do quarto: ");
        roomNumber = sc.nextInt();


        System.out.print("Data de check-in (dd/mm/aaaa): ");
        checkIn = simpleDateFormat.parse(sc.next());

        System.out.print("Data de check-out (dd/mm/aaaa): ");
        checkOut = simpleDateFormat.parse(sc.next());

        // se a data de checkout não for posterior a data de checkIn...
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva ! Data de saída(check-out) não pode ser inferir a data de entrada(check-in");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Entre com os dados para atualizare a reserva");

            System.out.print("Data de check-in (dd/mm/aaaa): ");
            checkIn = simpleDateFormat.parse(sc.next());

            System.out.print("Data de check-out (dd/mm/aaaa): ");
            checkOut = simpleDateFormat.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);

            if (error != null) {
                System.out.println("Erro na reserva: " + error);
            }else {
                System.out.println(reservation);

            }



        }


        sc.close();
    }
}