package edu.cnm.deepdive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.model.Schema;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Parser {

  private static final String TEST_SCHEMA_FILE = "test-schema.json";

  public static void main(String[] args) throws IOException {
    try (InputStream input = new FileInputStream(TEST_SCHEMA_FILE)) { /* Open file as InputStream */
      Parser parser = new Parser(); /* Parse schema */
      Schema schema = parser.parse(input);
      System.out.println(parser.getDdl(schema)); /* Print ddl string */
    }
  }

  private Schema parse(InputStream input) throws IOException {
    try (Reader reader = new InputStreamReader(input)) { /* reader to read from inputstream */
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      return gson.fromJson(reader, Schema.class);  /* Gson object to parse from reader */
    }
  }

  private String getDdl(Schema schema) {
    // TODO Assemble all ddl from objects read by Gson
    return null;
  }
}
