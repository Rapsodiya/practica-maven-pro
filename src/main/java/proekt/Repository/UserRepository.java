package proekt.Repository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import proekt.model.User;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.persistence.Entity;
import java.io.File;
import java.util.List;


public class UserRepository {
    public ArrayList<User> masssEmp = new ArrayList<>();


    public UserRepository(ArrayList<User> masssEmp) {
        this.masssEmp = masssEmp;
    }

    public UserRepository() {
        masssEmp = new ArrayList<>();
    }


    //добавление элемента в массив
    public void addEmp(User newUser) {
        masssEmp.add(newUser);
    }


    //удаление элемента из массива
    public void removeUser(int index) {
        for (int i = 0; i < masssEmp.size(); i++)
            if (masssEmp.get(i).getId() == index) {
                masssEmp.remove(i);
                break;
            }
    }


    //получение массива
    public ArrayList<User> getUserAll() {
        return masssEmp;
    }


    //получение элемента из массива
    public User _getUser(int index) {
        for (User user : masssEmp) {
            if (user.getId() == index) {
                return user;
            }
        }
        return null;
    }


    //запись файла формата XML
    public void record(User newUser) throws IOException {
        String filename = "User.XML";
        Document doc = new Document();
        doc.setRootElement(new Element("User"));
        for (User user : masssEmp) {
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
            }
        }


    //чтение файла формата XML
    public void giveElement(String fileName) throws JDOMException, IOException {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document jdomDocument = saxBuilder.build(new File(fileName));
            Element root = jdomDocument.getRootElement();
            List<Element> masEmp = root.getChildren("Employee");
            for (Element userEl : masEmp) {
                User user = new User();
                user.setId(Integer.parseInt(userEl.getAttributeValue("id")));
                user.setName(String.valueOf(userEl.getAttributeValue("name")));
                user.setDateBirthday(String.valueOf(userEl.getAttributeValue("dateBirthday")));
                user.setPhone(Long.parseLong(userEl.getAttributeValue("phone")));
                user.setSalary(Double.parseDouble(String.valueOf(userEl.getAttributeValue("salary"))));
                user.setIdDepartment(Integer.parseInt(userEl.getAttributeValue("idDepartment")));

                masssEmp.add(user);
            }
    }


    //коэф. эксцесса


}