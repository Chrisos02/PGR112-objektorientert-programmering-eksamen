package Eksamen;


import java.util.ArrayList;
import java.util.List;


// FIELDS
public class Event {
    private String id;
    private String name;
    private String username;
    private List<Guest> guests;

    // CONSTRUCTOR
    public Event(String id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.guests = new ArrayList<>();
    }
    // METHOD, addGuests
    public void addGuests (Guest guest) {
        this.guests.add(guest);
    }

    // METHODE, GetGuests
    public List<Guest> getGuests() {
        return this.guests;
    }

    // METHODE, ToString
    @Override
    public String toString() {
        String GuestName = guests.isEmpty() ? "" : guests.get(0).getName();
        //This returns the formatted string
        return "Event registered: EventID: " + id + "," +
                " Event name: " + name + "," +
                " Guest 1 name:" +  GuestName;
    }
}



















