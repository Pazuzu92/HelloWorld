import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name);

        if (!Files.exists(file.toPath()))
            throw new IllegalArgumentException();

        try (InputStream stream = new FileInputStream(name)) {
            byte[] bytes = IOUtils.toByteArray(stream);
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }
}
