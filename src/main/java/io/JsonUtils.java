package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import model.game.Game;

import java.io.IOException;
import java.util.List;
import java.util.TimeZone;
/**
 * this class has utils methods for input/output classes. 
 *
 */
public final class JsonUtils {
    private static JsonFileReader reader = new JsonFileReaderImpl("database.txt");
    private static JsonFileWriter writer = new JsonFileWriterImpl("database.txt");
    private JsonUtils() { }
    /**
     * 
     * @return ObjectMapper for serializing and deserializing objects
     */
    public static ObjectMapper getMapper() {
        return new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .registerModule(new Jdk8Module())
                .registerModule(new ParameterNamesModule())
                .registerModule(new JavaTimeModule())
                .enable(SerializationFeature.INDENT_OUTPUT)
                .setTimeZone(TimeZone.getDefault());
    }
    /**
     * add to database the game passed as argument.
     * @param game
     * @throws IOException
     */
    public static void addToDatabase(final Game game) throws IOException {
        final List<Game> games = reader.readFile();
        games.add(game);
        writer.writeFile(games);
    }
}
