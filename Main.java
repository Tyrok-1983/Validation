package maim;

import job.Job;

import javax.validation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws ParseException {
        ValidatorFactory validation = Validation.buildDefaultValidatorFactory();
        Validator validator = validation.getValidator();
        Job job = new Job();
        Set<ConstraintViolation<Job>> conSet= validator.validate(job);

        for (ConstraintViolation<Job> validator1 : conSet) {
            validator1.getInvalidValue();
            System.out.println(validator1);
        }
        // Выводим текущию дату
        System.out.println("--------------------");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        System.out.println(dateFormat.format(date));
        System.out.println("--------------------");
        // Преобразование строки в дату
        String afterDate1 = "20.02.2016";
        Date afterDate = dateFormat.parse(afterDate1);
        System.out.println(dateFormat.format(afterDate));
        System.out.println("--------------------");
        System.out.println(compeaDate(afterDate,date));
    }

    private static int compeaDate(Date date, Date afterDate) {
        // Сравнение что дата в прошлом
        System.out.println( date.after(afterDate));
        // Сравнение что дата в  будущем
        System.out.println( date.before(afterDate));
        // Сравнение что дата в равны
        System.out.println( date.compareTo(date));
        if (date.compareTo(afterDate) == 0){
            return 0;
        }else if (date.compareTo(afterDate) == 1){
            return 1;
        }else return -1;
    }

}
