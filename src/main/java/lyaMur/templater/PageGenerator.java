package lyaMur.templater;

import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lyaMur.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PageGenerator {

    private static PageGenerator pageGenerator;
    private Configuration cfg;

    public static PageGenerator instance(){
        if (pageGenerator == null){
            pageGenerator = new PageGenerator();
        }
        return pageGenerator;
    }

    public String getPage(String fileName, HashMap<String, Object> data){
        Writer stream = new StringWriter();
        /*try {
            //cfg.setDirectoryForTemplateLoading(new File("webapp/views/pages/" + fileName));
            File f = new File("/src/main/webapp/views/pages/Service.html");
            System.out.println(f.exists());
            Template template = cfg.getTemplate("/src/main/webapp/views/pages/" + fileName);
            template.process(data, stream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }*/
        return stream.toString();
    }

    private PageGenerator(){
        cfg = new Configuration();
    }
}
