import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lyaMur.utils.Constants;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import lyaMur.servlets.MainServlet;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        /*MainServlet mainServlet = new MainServlet();

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);

        context.addServlet(new ServletHolder(mainServlet), "/");

        server.start();
        server.join();
        System.out.println(server.isRunning());*/

        HashMap<String, Object> data = new HashMap<>();
        data.put("serviceTopick", "Лаборатория");
        data.put("serviceInfo", "Одним из найболее эфективных этапов " +
                "\tобследования Вашего питомца является лабораторные иследования, что позволяет " +
                "максимально точно и быстро поставить диагноз.");

        Configuration cfg = new Configuration();

        Writer stream = new StringWriter();
        try {
//            cfg.setDirectoryForTemplateLoading(new File(Constants.HTML_DIR));
            File f = new File("src/main/webapp/views/pages/Service.html");
            System.out.println(f.exists());
            Template template = cfg.getTemplate("src/main/webapp/views/pages/" + "Service.html");
            template.process(data, stream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
