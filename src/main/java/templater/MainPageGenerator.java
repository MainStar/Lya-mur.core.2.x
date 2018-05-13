package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import utils.Constants;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class MainPageGenerator {

    private static MainPageGenerator mainPageGenerator;
    private Configuration cfg;

    public static MainPageGenerator instance(){
        if (mainPageGenerator == null){
            mainPageGenerator = new MainPageGenerator();
        }
        return mainPageGenerator;
    }

    public String getPage(String fileName, Map<String, String> data){
        Writer stream = new StringWriter();
        try {

            cfg.setDirectoryForTemplateLoading(new File(Constants.HTML_DIR));
            Template template = cfg.getTemplate(fileName);
            template.process(data, stream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

    private MainPageGenerator(){
        cfg = new Configuration();
    }

}
