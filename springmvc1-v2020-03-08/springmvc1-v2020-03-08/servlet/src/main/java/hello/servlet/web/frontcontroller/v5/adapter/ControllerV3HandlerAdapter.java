package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;

        HashMap<String, String> paramMap = craeteParamMap(request);
        ModelView mv = controller.process(paramMap);

        return mv;
    }

    private HashMap<String, String> craeteParamMap(HttpServletRequest request) {
        HashMap<String, String> paramHashMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(
                        paramName ->
                                paramHashMap.put(paramName, request.getParameter(paramName))
                );
        return paramHashMap;
    }
}
