import io.javalin.Javalin;


public class App {

    public static void main(String[] args) {
        FloatNumber number = new FloatNumber(4);


        Javalin app = Javalin.create()
                .enableStaticFiles("/public")
                .start(7000);

        app.get("/number", ctx -> {
            // if(ctx.queryParam("val").length() == 0) return;
            System.out.println("number = " + number);
            number.put((ctx.queryParam("val").charAt(0)));
            System.out.println("number = " + number);
            ctx.result(number.toString());
        });
    }
}