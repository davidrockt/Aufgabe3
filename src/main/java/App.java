import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, Float> exchange = new HashMap<String, Float>(){{
            put("euro", 1f);
            put("dollar", 1.12f);
            put("yuan", 7.54f);
            put("bitcoin", 0.0002f);
        }};
        T3 game = new T3(); // must be effectively final
        Javalin app = Javalin.create()
                .enableStaticFiles("/public")
                .start(7000);
        app.get("/move", ctx -> {
            int input = Integer.parseInt(ctx.queryParam("pos"));
            if (game.isValidMove(input)) game.move(input);
            ctx.result(game.toString());
        });
        app.get("/submit", ctx -> {
            if(ctx.queryParam("val").length() == 0) return;
            int input = Integer.parseInt(ctx.queryParam("val"));
            float change = exchange.get(ctx.queryParam("curr"));
            System.out.println("input = " + input);
            System.out.println("currency = " + change);
            ctx.result(Float.toString(Math.round(100.0f * input * change) / 100.0f));
        });
        app.get("/newgame", ctx -> {
            System.out.println("newgame !");
            game.undoAll();
            ctx.result(game.toString());
        });
        app.get("/undo", ctx -> {
            game.undo();
            ctx.result(game.toString());
        });
        app.get("/rows", ctx -> ctx.result(game.toString()));
    }
}