/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Queue and Stack Q1 - Ticket booking system using Queue (LinkedList)
 */
package queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class Q01_TicketBookingQueue {

    static int availableTickets = 3;

    public static void main(String[] args) {
        Queue<String> bookingQueue = new LinkedList<>();

        // Customers join the queue (FIFO)
        String[] customers = {"Ansh", "Riya", "Karan", "Neha", "Arjun"};
        for (String c : customers) {
            bookingQueue.offer(c);
            System.out.println(c + " joined the queue. Queue: " + bookingQueue);
        }

        System.out.println("\nCounter opens. Tickets available: " + availableTickets);
        while (!bookingQueue.isEmpty()) {
            System.out.println("Next in line: " + bookingQueue.peek());
            String customer = bookingQueue.poll();
            if (availableTickets > 0) {
                availableTickets--;
                System.out.println("  Ticket booked for " + customer + ". Tickets left: " + availableTickets);
            } else {
                System.out.println("  Sorry " + customer + ", tickets sold out!");
            }
        }
        System.out.println("Queue empty: " + bookingQueue.isEmpty());
    }
}
