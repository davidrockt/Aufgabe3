import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static int count = 0;
    public static void main(String[] args) {
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
            int input = Integer.parseInt(ctx.queryParam("val"));
            System.out.println("input = " + input);
            ctx.html(" " + input);
        });
        app.get("/newgame", ctx -> {
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