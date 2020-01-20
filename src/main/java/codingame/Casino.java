package codingame;

import java.util.*;

public class Casino {

    public static int computeDayGains(int nbSeats, int[] payingGuests, int[] guestMovements) {
        //declaring the sum to return
        int sum = 0;
        //filling the guest list
        Map<Integer, Guest> guests = new HashMap<>();
        for (int i = 0; i < payingGuests.length; i++) {
            guests.put(i, new Guest(payingGuests[i], false, false));
        }
        //List of seated guest
        List<Guest> seatedGuests = new ArrayList<>();
        //List of waiting guest
        Queue<Guest> waitingGuest = new ArrayDeque<>();
        //play the list of mouvements of guests and do the calculation
        for (int i = 0; i < guestMovements.length; i++) {
            Guest guest = guests.get(guestMovements[i]);
            //guest is not already seated and there is free space
            if (!seatedGuests.contains(guest) && nbSeats > 0) {
                //we seat the guest
                seatedGuests.add(guest);
                //we remove a free seat
                nbSeats -= 1;
                //and the guest pay if he hasnt paid already
                sum = getPaymentFromGuest(sum, guest);
                //if guest is already seated he just leave his seat
            } else if (seatedGuests.contains(guest)) {
                //we seat the guest
                seatedGuests.remove(guest);
                //we add a free seat
                nbSeats += 1;
                //when we free a seat, we can give it to a waiting guest
                Guest poll = waitingGuest.poll();
                if (poll != null) {
                    //we seat the guest
                    seatedGuests.add(poll);
                    //we remove a free seat
                    nbSeats -= 1;
                    //and the guest pay if he hasnt paid already
                    sum = getPaymentFromGuest(sum, poll);
                    //guest dont wait anymore
                    poll.setHasWaited(false);
                }
            }
            //if there is no available seat, if we have not waited yet, we wait
            else if (nbSeats < 0 && !guest.hasWaited()) {
                guest.setHasWaited(true);
                waitingGuest.add(guest);
            }
        }
        return sum;
    }

    private static int getPaymentFromGuest(int sum, Guest guest) {
        if (!guest.hasAlreadyPaid()) {
            sum += guest.getWillingToPay();
            guest.setHasAlreadyPaid(true);
        }
        return sum;
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String[] args) {
        //Enough seats
        int nbSeats = 100;
        int[] payingGuests = new int[]{25, 10, 5, 30, 15};
        int[] guestMovements = new int[]{4, 4, 3, 2, 3, 0, 0, 2};
        int res = computeDayGains(nbSeats, payingGuests, guestMovements);
        System.out.println(res); //expected 75
        //Wait in line
        nbSeats = 8;
        payingGuests = new int[]{8,12,18,29,6,33,13,7,21,11,89,12};
        guestMovements = new int[]{0,1,2,3,4,5,6,7,8,9,10,7,6,5,4,3,2,1,0,8,9,10};
        res = computeDayGains(nbSeats, payingGuests, guestMovements);
        System.out.println(res); //expected 247
    }

    static class Guest {
        private int willingToPay;
        private boolean hasWaited;
        private boolean hasAlreadyPaid;

        Guest(int willingToPay, boolean waited, boolean alreadyPaid) {
            this.willingToPay = willingToPay;
            this.hasWaited = waited;
            this.hasAlreadyPaid = alreadyPaid;
        }

        public int getWillingToPay() {
            return willingToPay;
        }

        public boolean hasWaited() {
            return hasWaited;
        }

        public void setHasWaited(boolean waited) {
            this.hasWaited = waited;
        }

        public boolean hasAlreadyPaid() {
            return hasAlreadyPaid;
        }

        public void setHasAlreadyPaid(boolean alreadyPaid) {
            this.hasAlreadyPaid = alreadyPaid;
        }
    }
}
