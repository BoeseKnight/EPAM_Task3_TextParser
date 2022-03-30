package by.epam.lamashka.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReader implements Reader {
  @Override
  public String read(String filePath) {
    Scanner in = null;
    try {
      in = new Scanner(new File(filePath));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return in.useDelimiter("\\A").next();
  }
}
