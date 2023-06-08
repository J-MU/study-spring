package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


/*
    1. http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(
                        paramName -> System.out.println(paramName +" = " + request.getParameter(paramName))
                );

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        System.out.println("[단일 파라미터 조회] - end");

        String username = request.getParameter("username");
        String age = request.getParameter("age");


        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        List<String> usernames = List.of(request.getParameterValues("username"));

        usernames.stream().forEach(
                um -> System.out.println("username = " + um)
        );

    }
}
