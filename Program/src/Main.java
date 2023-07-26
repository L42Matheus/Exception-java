import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = input.nextInt();

        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkin = simpleDateFormat.parse(input.next());

        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkout = simpleDateFormat.parse(input.next());

        if (!checkout.after(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check in date");
        }else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);


            System.out.println();
            System.out.println("Enter data to update the reservation");

            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkIn = simpleDateFormat.parse(input.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkOut = simpleDateFormat.parse(input.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation " + reservation);
        }

        input.close();

    }
}