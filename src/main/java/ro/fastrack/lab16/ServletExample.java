package ro.fastrack.lab16;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author flo
 * @since 15.06.2022.
 */
@WebServlet("/servlets")
public class ServletExample extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Am ceva de lucru! yeey!");

        String numeMagazin = req.getParameter("abc");
        System.out.println("Nume magazin " + numeMagazin);

        int oraInchidere = 0;
        try {
            oraInchidere = Integer.parseInt(req.getParameter("deschisPanaLa"));
        } catch (NumberFormatException e) {
            resp.setStatus(422);
            try(PrintWriter writer = resp.getWriter()) {
                writer.println("Grija la parametrul deschisPanaLa. Trebuie sa fie intreg si ai pus:" + req.getParameter("deschisPanaLa"));
                return;
            }
        }
        System.out.println("deschis pana la" + oraInchidere);


        try(PrintWriter writer = resp.getWriter()) {
            //<html><body><b>text boldat<b><body></html>
            writer.println("<html><body><b>"+numeMagazin + " deschis pana la " + oraInchidere +"</b></body></html>");
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ma initializez!");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("Urmeaza sa ma inchid.");
        super.destroy();
    }
}
