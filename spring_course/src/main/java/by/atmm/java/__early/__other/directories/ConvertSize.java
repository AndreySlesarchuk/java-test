package by.atmm.java.__early.__other.directories;

/**
 * Created by Andrey Slesarchuk on 10/26/2020.
 */
public class ConvertSize {

  public String getSize(Long sizeBytes) {
    long sizeKb = sizeBytes / 1024;
    long sizeMb = sizeKb / 1024;
    long sizeGb = sizeMb / 1024;
    if (sizeGb > 0) {
      return sizeGb + " GB";
    }
    else
      if (sizeMb > 0) {
        return sizeMb + " MB";
      }
      else {
        return sizeKb + " KB";
      }
  }

}
