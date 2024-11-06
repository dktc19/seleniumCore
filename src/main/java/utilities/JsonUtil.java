package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.TestContextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/** JsonHelper class to convert JSON files to object. */
public class JsonUtil {
  private static final Logger LOGGER = LogManager.getLogger(JsonUtil.class);
  private static volatile JsonUtil instance;

  private JsonUtil() {}

  public static JsonUtil getInstance() {
    if (instance == null) {
      synchronized (JsonUtil.class) {
        if (instance == null) {
          instance = new JsonUtil();
        }
      }
    }
    return instance;
  }

  /**
   * Converts a JSON file to an object of type T.
   *
   * @param jsonFilePath the JSON string
   * @param clazz the type class
   * @return an object of generic type
   */
  public <T> T convertFileJsonToObject(String jsonFilePath, Class<T> clazz) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(new File(jsonFilePath), clazz);
    } catch (IOException e) {
      String className = clazz.getSimpleName();
      LOGGER.error("Error in mapping to response [{}] class. {}", className, e.getMessage());
      throw new TestContextException(
          String.format("Error in mapping to response [%s] class. %s", className, e.getMessage()),
          e);
    }
  }
}
