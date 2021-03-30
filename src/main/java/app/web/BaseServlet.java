package app.web;

import app.model.Item;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = {"/hello"})
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {

        Item itemOne = new Item("One");
        Item itemTwo = new Item("Two");

        Set<Item> items = new HashSet<>();
        items.add(itemOne);
        items.add(itemTwo);

        req.setAttribute("items", items);
        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

}
