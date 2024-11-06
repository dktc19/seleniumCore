package constants;

import java.io.File;

public class GlobalConfig {
  public static String USER_DIR = System.getProperty("user.dir");
  public static String REMOTE_JSON =
      String.join(File.separator, "src", "test", "resources", "config", "remote_info.json");
  public static boolean IS_GRID = Boolean.parseBoolean(System.getProperty("grid"));
  public static final long WAIT_TIMEOUT_5_SECONDS = 5;
  public static final long WAIT_TIMEOUT_10_SECONDS = 10;
  public static final long WAIT_TIMEOUT_30_SECONDS = 30;
}
