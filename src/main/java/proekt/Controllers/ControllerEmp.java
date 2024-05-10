package proekt.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class ControllerEmp {

    @GetMapping
    public String info() {
        return "Название: Сотрудники предприятия\n" +
                "Работу выполнила: Ульяна Кузьмина\n " +
                "Вариант: 1.1\n" +
                "Версия: ФИНАЛЬНАЯ\n";
    }


}