import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Field[] Data = new Field[7];
        int n;
        int k;
        // эталонный массив для проверки возможности предоставления права доступа, 1 индекс отвечает за должность
        // 2 индекс отвечает за роль
        String [][] origStr = {{"11111", "11111", "10000", "10000", "10000", "10000","10011", "10011"},
                {"10000", "10000", "10000", "11111","10010", "10010", "10000", "10000"},
                {"10000", "10000", "11111", "10000", "10010", "10010","10000", "10000"},
                {"10000", "10000", "10000", "10000", "10000", "10000", "10000", "10000"}
        };
        // массив для указания подсказки в сообщении о некорретном запросе прав
        String [] accessRight = {"просмотр", "создание", "изменение", "обработка", "удаление"};
        String[] accessStr = new String[8];
        for (int i = 0; i < 4; i++) {
            Data[i] = new TextChecker();
        }
        Data[4] = new NumChecker();
        Data[5] = new Positionchecker();
        Data[6] = new EmailChecker();
        // список сообщений о необходимости ввода данных пользователя
        ArrayList<String> message = new ArrayList<String>();
        // список сообщений для ролей
        ArrayList<String> messageRole = new ArrayList<String>();
        boolean flag;
        int counter = 0;
        Scanner in = new Scanner(System.in, "Cp866");
        // При вводе данных с консоли в IDE кодировка должна быть Cp866 (DOS 866), иначе не будет поддерживаться русский ввод, или необходимо убрать параметр Cp866 в функции
        message.add("Введите ФИО (только буквы)");
        message.add("Введите гражданство (только буквы)");
        message.add("Введите имя организации (только буквы)");
        message.add("Введите подразделение организации (только буквы)");
        message.add("Введите номер телефона (только цифры без пробелов)");
        message.add(" Нажмите 1, если ваша должность специалист \n Нажмите 2, если ваша должность бухгалтер \n Нажмите 3, если ваша должность директор \n Нажмите 4, если ваша должность аудитор \n");
        message.add("Введите емейл (в формате текст@текст.текст)");
        messageRole.add("Введите права для роли Инициатор платежа (валюта)");
        messageRole.add("Введите права для роли Инициатор платежа (рубли)");
        messageRole.add("Введите права для роли Ответственный за ЭП (1 лицо организации)");
        messageRole.add("Введите права для роли Ответственный за ЭП (2 лицо организации)");
        messageRole.add("Введите права для роли Ответственный за загрузку выписок");
        messageRole.add("Введите права для роли Ответственный за согласование платежа");
        messageRole.add("Введите права для роли Специалист по отправке платежей (валюта)");
        messageRole.add("Введите права для роли Специалист по отправке платежей (рубли)");


        while (counter < 7) {
            flag = true;
            while (flag) {
                System.out.println(message.get(counter));
                Data[counter].inputText = in.nextLine();
                if (Data[counter].checkField()) {
                    flag = false;
                    counter++;
                } else
                    System.out.println("Некорректные данные");
            }
        }
        System.out.println("Необходимо ввести 5 цифр без пробела для каждой роли, где 1  доступ необходим, 0  доступ не нужен последовательно для прав просмотр, создание, изменение, обработка, удаление, Пример:11111 доступны все права для роли");

        n = Integer.parseInt(Data[5].inputText) - 1;
        for (int j=0 ;j < 8; j++) {
            k=0;
            flag = true;
            while (flag) {
            System.out.println(messageRole.get(j));
            accessStr[j] = in.nextLine();
            if (accessStr[j].matches("[0,1]{5}")) {
                while (k < 5) {
                        if (accessStr[j].charAt(k) <= origStr[n][j].charAt(k)) {
                            k++;
                            flag =false;
                        } else {
                            System.out.println("Некорректные данные, недоступно право " + accessRight[k]);
                            System.out.println(messageRole.get(j));
                            accessStr[j] = in.nextLine();
                            k=0;
                        }
                    }
                }

            else{
                System.out.println("Данные введены некорректно, введите последовательность из 5 символов, состоящую из 0 и 1 без пробелов");
            }

            }

        }

System.out.println("Заявка на присвоение доступа создана");
        Thread.sleep(5000);
    }
}

