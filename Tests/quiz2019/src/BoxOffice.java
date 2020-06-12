import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxOffice {
    private static Map<Concert, Integer> concerts = new HashMap<>();

    public static List<Ticket> buy(Concert concert, int nPeople) throws InvalidTicket {
        if(!concerts.containsKey(concert)) concerts.put(concert, 1);

        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < nPeople; i++) {
            tickets.add(new Ticket(concerts.get(concert), concert));
            concerts.put(concert, concerts.get(concert) + 1);
        }

        return tickets;
    }
}
