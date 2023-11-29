package by.atmm.java.__topics.directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;


/**
 * Created by Andrey Slesarchuk on 10/26/2020.
 */

public class DirectoryTest {

  static Logger log = Logger.getLogger(String.valueOf(DirectoryTest.class));

  public static void main(String[] args) {
    Path path = Paths.get("d:/__downloads");
    Long dirSize = getDirectorySizeJava8(path);
    log.info("Directory " + path.toString() + " Size : " + new ConvertSize().getSize(dirSize) + " - " + dirSize);

    dirSize = FileUtils.sizeOfDirectory(path.toFile());
    log.info("(FileUtils) Directory " + path.toString() + " Size : " + new ConvertSize().getSize(dirSize) + " - " + dirSize);

    dirSize = getDirectorySizeLegacy(path.toFile());
    log.info("(Legacy) Directory " + path.toString() + " Size : " + new ConvertSize().getSize(dirSize) + " - " + dirSize);

  }

  // size of directory in bytes
  public static long getDirectorySizeJava8(Path path) {
    long size = 0;
    // need close Files.walk
    try (Stream<Path> walk = Files.walk(path)) {
      size = walk
          // .peek(System.out::println) // debug
          .filter(Files::isRegularFile).mapToLong(p -> {
            // ugly, can pretty it with an extract method
            try {
              return Files.size(p);
            }
            catch (IOException e) {
              System.out.printf("Failed to get size of %s%n%s", p, e);
              return 0L;
            }
          }).sum();
    }
    catch (IOException e) {
      System.out.printf("IO errors %s", e);
    }
    return size;
  }

  public static long getDirectorySizeLegacy(File dir) {
    long length = 0;
    File[] files = dir.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isFile())
          length += file.length();
        else
          length += getDirectorySizeLegacy(file);
      }
    }
    return length;
  }
}
