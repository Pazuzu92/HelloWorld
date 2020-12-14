


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final String PATH = "C:\\Users\\DeadCalm\\Study\\HelloWorld\\homework08_classloaders\\src\\main\\java\\";
    private static final String START_OUTPUT_CODE =
            "public class SomeClass implements Worker {\n" +
                    "\t@Override\n" +
                    "\tpublic void doWork() {\n" +
                    "\t\tSystem.out.println(\"This is doWork\");\n";
    private static final String END_OUTPUT_CODE = "\t}\n}\n";

    public static void main(String[] args) throws IOException, InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String code = "";

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        System.out.println("Enter your code here: \n");
        do {
            s = bf.readLine();
            code += s +"\n";
        } while (!s.equals(""));

        try (PrintWriter print = new PrintWriter(PATH+"SomeClass.java", "UTF-8")) {
            print.write(START_OUTPUT_CODE + code + END_OUTPUT_CODE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        javaCompiler.run(null, null, null, PATH + "SomeClass.java");


        createClass();
    }

    public static void createClass() throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = new MyClassLoader().findClass(PATH +"SomeClass.class");

        Constructor<?> constructor = clazz.getConstructors()[0];

        Worker object = (Worker) constructor.newInstance();
        object.doWork();
    }
}
