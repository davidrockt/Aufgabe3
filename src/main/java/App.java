import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create()
            .enableStaticFiles("/public")
            .start(7070);
        
        app.get("/input", ctx -> {
            // System.out.println("ctx.queryParam(\"currency\") = " + ctx.queryParam("currency"));
            ctx.html("Does this work?");
        });
    }
}