
import co.edu.uptc.test.ManagerProperties;
import src.co.edu.uptc.services.ServicesParcial;

public class App {

    public static void main(String[] args) throws Exception {
        ServicesParcial servicesParcial= new ServicesParcial();
        ManagerProperties managerProperties= new ManagerProperties();
        managerProperties.setFileName(".\\src\\co\\edu\\uptc\\data\\FileProperties.txt");
        try {
            servicesParcial.setPath(managerProperties.getValue("Filepeople"));
            servicesParcial.readyXml();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
