import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static Map<String, String> reservations = new HashMap<String, String>() {{
        put("saturday", "No reservation");
        put("sunday", "No reservation");
    }};

    public static void main(String[] args) {
        Javalin app = Javalin.create()
            .enableStaticFiles("/public")
            .start(7070);

        app.post("/make-reservation", ctx -> {
            reservations.put(ctx.formParam("day"), ctx.formParam("time"));
            ctx.html("Your reservation has been saved");
        });

        /* Die für einen Tag hinterlegte Uhrzeit wird abgefragt.
         */
        app.get("/check-reservation", ctx -> {
            ctx.html("hello people");
        });
    }
}