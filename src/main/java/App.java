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
        Javalin app = Javalin.create()
                .enableStaticFiles("/public")
                .start(7000);
        app.get("/submit", ctx -> {
            if(ctx.queryParam("val").length() == 0) return;
            int input = Integer.parseInt(ctx.queryParam("val"));
            float change = exchange.get(ctx.queryParam("curr"));
            // System.out.println("input = " + input);
            // System.out.println("currency = " + change);
            ctx.result(Float.toString(Math.round(100.0f * input * change) / 100.0f));
        });
    }
}