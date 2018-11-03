package cit360servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(name = "/AnswerServlet")
public class AnswerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AnswerServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");

        if(Pattern.compile(Pattern.quote("dark"), Pattern.CASE_INSENSITIVE).matcher(answer).find()){
            System.out.println(answer + " is correct. It contained the string \"dark\".");

            PrintWriter writer = response.getWriter();
            String htmlResponse = "<html>";
            htmlResponse += "<head>";
            htmlResponse += "<body style=\"background-color: #96ddfe;\">";
            htmlResponse += "<h2>Your guess was: " + answer + ". That is correct!!</h2>";
            htmlResponse += "<button type=\"button\" name=\"back\" onclick=\"history.back()\">back</button>";
            htmlResponse += "</body>";
            htmlResponse += "</head>";
            htmlResponse += "</html>";

            writer.println(htmlResponse);

        } else {
            System.out.println(answer + " is incorrect. It did not contain the string \"dark\".");

            PrintWriter writer = response.getWriter();
            String htmlResponse = "<html>";
            htmlResponse += "<head>";
            htmlResponse += "<body style=\"background-color: #96ddfe;\">";
            htmlResponse += "<h2>Your guess was: " + answer + ". That is incorrect. Try again!</h2>";
            htmlResponse += "<button type=\"button\" name=\"back\" onclick=\"history.back()\">back</button>";
            htmlResponse += "</body>";
            htmlResponse += "</head>";
            htmlResponse += "</html>";

            writer.println(htmlResponse);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
