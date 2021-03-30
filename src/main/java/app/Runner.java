package app;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.JarScanner;
import org.apache.tomcat.util.scan.StandardJarScanner;

import java.io.File;

public class Runner {

    public static void main(String[] args) throws Exception {

        int port = 8080;
        String baseDir = ".";
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(port);

        tomcat.setBaseDir("tomcat." + port);
        tomcat.getHost().setAppBase(baseDir);
        tomcat.enableNaming();

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/hi", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("" + webappDirLocation).getAbsolutePath());

        ClassLoader classLoader = Runner.class.getClassLoader();
        ctx.setParentClassLoader(classLoader);

        File additionWebInfClasses = new File("output/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        File configFile = new File(webappDirLocation + "WEB-INF/web.xml");
        ctx.setDefaultWebXml(configFile.getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }

}
