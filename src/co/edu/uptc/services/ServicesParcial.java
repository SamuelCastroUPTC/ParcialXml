package src.co.edu.uptc.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import src.co.edu.uptc.models.Person;



public class ServicesParcial {
    
    private String path;
    private List<Person> people;


    public ServicesParcial(){
        people= new ArrayList<Person>();
    }

    public void setPath(String path){
        this.path=path;
    }
    

    private int mayorSalary(){
        int salaryProm=0;
        int count=0;
        for (Person person : people) {
            salaryProm=salaryProm+person.getSalary();
            count=count+1;
        }
        salaryProm=salaryProm/count;
        salaryProm=Math.abs(salaryProm);
        return salaryProm;
    }

    private void readxml(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(path));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("persona");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element personElement = (Element) nodeList.item(i);
                Person person1= new Person();
                person1.setAge(Integer.parseInt(personElement.getElementsByTagName("edad").item(0).getTextContent()));
                person1.setName(personElement.getElementsByTagName("nombre").item(0).getTextContent());
                person1.setLastname(personElement.getElementsByTagName("apellidos").item(0).getTextContent());
                person1.setSalary(Integer.parseInt(personElement.getElementsByTagName("salario").item(0).getTextContent()));
                people.add(person1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readyXml(){
        readxml();
        writeXmlMayor();
        writeXmlMenor();
    }

    private void writeXmlMayor(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("personas");
            doc.appendChild(rootElement);
            for (Person person : people) {
                if (person.getSalary()>=mayorSalary()) {
                    Element empleado1 = doc.createElement("persona");
                rootElement.appendChild(empleado1);
                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(person.getName()));
                empleado1.appendChild(nombre);
                Element apellido = doc.createElement("apellido");
                apellido.appendChild(doc.createTextNode(person.getLastname()));
                empleado1.appendChild(apellido);
                Element edad = doc.createElement("edad");
                edad.appendChild(doc.createTextNode(person.getAge()+""));
                empleado1.appendChild(edad);
                Element salario = doc.createElement("salario");
                salario.appendChild(doc.createTextNode(person.getSalary()+""));
                empleado1.appendChild(salario);
                }
            }

            File xmlFile = new File(".\\personmayor.xml");
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeXmlMenor(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("personas");
            doc.appendChild(rootElement);
            for (Person person : people) {
                if (person.getSalary()<mayorSalary()) {
                    Element empleado1 = doc.createElement("persona");
                rootElement.appendChild(empleado1);
                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(person.getName()));
                empleado1.appendChild(nombre);
                Element apellido = doc.createElement("apellido");
                apellido.appendChild(doc.createTextNode(person.getLastname()));
                empleado1.appendChild(apellido);
                Element edad = doc.createElement("edad");
                edad.appendChild(doc.createTextNode(person.getAge()+""));
                empleado1.appendChild(edad);
                Element salario = doc.createElement("salario");
                salario.appendChild(doc.createTextNode(person.getSalary()+""));
                empleado1.appendChild(salario);
                }
            }

            File xmlFile = new File(".\\personmenor.xml");
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
