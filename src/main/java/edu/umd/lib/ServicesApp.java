package edu.umd.lib;

import org.apache.camel.CamelContext;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

import edu.umd.lib.routes.SolrRouter;

/****
 * Main Service App
 *
 * @author rameshb
 *
 */
public class ServicesApp {
  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();

    PropertiesComponent propertiesComponent = context.getComponent("properties", PropertiesComponent.class);
    propertiesComponent.setLocation("classpath:edu.umd.lib.boxsolrconnector.cfg");
    propertiesComponent.setSystemPropertiesMode(PropertiesComponent.SYSTEM_PROPERTIES_MODE_OVERRIDE);
    context.addRoutes(new SolrRouter());

    context.start();
    Thread.sleep(1000 * 60 * 15); // 15 min
    context.stop();
  }

}
