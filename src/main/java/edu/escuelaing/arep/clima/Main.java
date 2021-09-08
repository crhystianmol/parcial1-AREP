package edu.escuelaing.arep.clima;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class Main {

    private  static  Connection connection;

    public static void main(String[] args) {

        port(getPort());
        System.out.println(getPort());
        connection = new Connection();

        get("/clima", (req, res) -> inputDataPage(req,res));

    }
    private static String inputDataPage(Request req, Response res) throws Exception {
        String lugar = req.queryParams("lugar");
        System.out.println(lugar);
        connection.getWeather(lugar);
        String rta = connection.getURL();
        System.out.println(rta.toString());
        return rta;
    }

    private static String getClima(String city) throws Exception {
        String rta = "";
        connection.getWeather(city);
        rta = connection.getURL();
        return rta;
    }



    /**
     * retorna el puerto
     * @return retorna el puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
