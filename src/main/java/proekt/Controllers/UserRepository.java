package proekt.Controllers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class UserRepository {
    public ArrayList<proekt.model.User> masssEmp = new ArrayList<>();


    public UserRepository(ArrayList<proekt.model.User> masssEmp) {
        this.masssEmp = masssEmp;
    }

    public UserRepository() {
        masssEmp = new ArrayList<>();
    }


    //добавление элемента в массив
    public void addEmp(proekt.model.User newUser) {
        masssEmp.add(newUser);
    }


    //удаление элемента из массива
    public void removeUser(long index) {
        for (int i = 0; i < masssEmp.size(); i++)
            if (masssEmp.get(i).getId() == index) {
                masssEmp.remove(i);
                break;
            }
    }


    //получение массива
    public ArrayList<proekt.model.User> getUserAll() {
        return masssEmp;
    }


    //получение элемента из массива
    public proekt.model.User _getUser(Long index) {
        for (proekt.model.User user : masssEmp) {
            if (user.getId() == index) {
                return user;
            }
        }
        return null;
    }


    //запись файла формата XML
    public Object record(String fileName) throws IOException {
        String filename = "User.XML";
        Document doc = new Document();
        doc.setRootElement(new Element("User"));
        for (proekt.model.User user : masssEmp) {
            Element userElement = new Element("Employee");
            userElement.setAttribute("id", String.valueOf(user.getId()));
            userElement.setAttribute("name", String.valueOf(user.getName()));
            userElement.setAttribute("dateBirthday", String.valueOf(user.getDateBirthday()));
            userElement.setAttribute("phone", String.valueOf(user.getPhone()));
            userElement.setAttribute("salary", String.valueOf(user.getSalary()));
            userElement.setAttribute("idDepartment", String.valueOf(user.getIdDepartment()));
            doc.getRootElement().addContent(userElement);

            // Документ JDOM сформирован и готов к записи в файл
            XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
            // сохнаряем в файл
            xmlWriter.output(doc, new FileOutputStream("User.XML"));
            xmlWriter.output(doc, System.out);
            return doc;
        }
        return null;
    }


    //чтение файла формата XML
    public ArrayList<proekt.model.User> giveElement(String fileName) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document jdomDocument = saxBuilder.build(new File(fileName));
        Element root = jdomDocument.getRootElement();
        List<Element> masEmp = root.getChildren("Employee");
        for (Element userEl : masEmp) {
            proekt.model.User user = new proekt.model.User();
            user.setId(Integer.parseInt(userEl.getAttributeValue("id")));
            user.setName(String.valueOf(userEl.getAttributeValue("name")));
            user.setDateBirthday(String.valueOf(userEl.getAttributeValue("dateBirthday")));
            user.setPhone(Long.parseLong(userEl.getAttributeValue("phone")));
            user.setSalary(Double.parseDouble(String.valueOf(userEl.getAttributeValue("salary"))));
            user.setIdDepartment(Integer.parseInt(userEl.getAttributeValue("idDepartment")));

        }
        return masssEmp;
    }

    public int size() {
        return masssEmp.size();
    }

    //коэф. эксцесса ИЗИ
    public double getKurtosis() {
        double salary = 0;
        double matpor = 0;
        double dispersia = 0;
        //получение средней зарплаты
        for (proekt.model.User userloc : masssEmp) {
            salary += userloc.getSalary();
        }
        //получение дисперсии и центрального эмпирического момента четвёртого порядка
        double averageSalary = (salary / masssEmp.size());
        for (proekt.model.User userloc : masssEmp) {
            double locSalary = userloc.getSalary();
            matpor += pow((locSalary - averageSalary), 4);
            dispersia = dispersia + pow((locSalary - averageSalary), 2);
        }
        double matporFour = matpor / masssEmp.size();
        double averageOtkl = pow(sqrt(dispersia / masssEmp.size()), 4);
        //любимый эксцесс
        double kurtosis = (matporFour / averageOtkl) - 3;
        return kurtosis;
    }

}
