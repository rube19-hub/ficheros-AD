package repositorio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(FileOutputStream fos) throws IOException {
        super();
    }
}
