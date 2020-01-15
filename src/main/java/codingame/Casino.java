package codingame;

import java.io.PrintStream;
import java.util.*;

public class Casino {

    public static int computeDayGains(int nbSeats, int[] payingGuests, int[] guestMovements) {
        //declaring the sum to return
        int sum = 0;
        //filling the guest list
        Map<Integer,Guest> guests = new HashMap<>();
        for(int i=0;i<payingGuests.length;i++){
            guests.put(i,new Guest(payingGuests[i],false,false));
        }
        //play the list of mouvements of guests and do the calculation
        for(int i=0;i<guestMovements.length;i++){
            Guest guest = guests.get(i);
            //check if there is empty seat
            if(nbSeats > 0){
                //if there is seat available, if the guest is new he can eat and pay
                if(!guest.hasAlreadyPaid()){
                    sum += guest.getWillingToPay();
                    guest.setHasAlreadyPaid(true);
                }
                //we remove a free seat
                nbSeats -= 1;
            //if there is no available seat, if we have not waited yet, we wait
            } else if(!guest.hasWaited()){
                guest.setHasWaited(true);
            }
        }
        return sum;
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        //Scanner in = new Scanner(System.in);
        int nbSeats = /*in.nextInt()*/5;
        int nbGuests = /*in.nextInt()*/5;
        int nbMovements = /*in.nextInt()*/5;
        int[] payingGuests = new int[nbGuests];
        for (int i = 0; i < nbGuests; i++) {
            payingGuests[i] = nbGuests+i/*in.nextInt()*/;
        }
        int[] guestMovements = new int[nbMovements];
        for (int i = 0; i < nbMovements; i++) {
            guestMovements[i] = nbMovements+i/*in.nextInt()*/;
        }
        int res = computeDayGains(nbSeats, payingGuests, guestMovements);
        System.out.println(res);
    }

    static class Guest {
        int willingToPay;
        boolean hasWaited;
        boolean hasAlreadyPaid;

        public Guest(int willingToPay, boolean hasWaited, boolean hasAlreadyPaid) {
            this.willingToPay = willingToPay;
            this.hasWaited = hasWaited;
            this.hasAlreadyPaid = hasAlreadyPaid;
        }

        public int getWillingToPay() {
            return willingToPay;
        }

        public boolean hasWaited() {
            return hasWaited;
        }

        public void setHasWaited(boolean hasWaited) {
            this.hasWaited = hasWaited;
        }

        public boolean hasAlreadyPaid() {
            return hasAlreadyPaid;
        }

        public void setHasAlreadyPaid(boolean hasAlreadyPaid) {
            this.hasAlreadyPaid = hasAlreadyPaid;
        }
    }
}
