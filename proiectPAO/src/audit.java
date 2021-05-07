import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class audit {
    FileWriter out;
    public audit() {
        try{this.out=new FileWriter("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/audit.csv");}catch(IOException e){e.printStackTrace();}
    }

    final DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public void Audit(String action) throws IOException {
        out.append(action);
        out.append(",");
        out.append(date.format(LocalDateTime.now()));
        out.append("\n");
        out.flush();
    }
}
