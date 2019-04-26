import io.javalin.Javalin;


public class App {

    public static void main(String[] args) {
        FloatNumber number = new FloatNumber();


        Javalin app = Javalin.create()
                .enableStaticFiles("/public")
                .start(7000);

        app.get("/number", ctx -> {
            // if(ctx.queryParam("val").length() == 0) return;
            int input = Integer.parseInt(ctx.queryParam("val"));
            // System.out.println("input = " + input);
            ctx.result(Integer.toString(input));
        });
    }
}