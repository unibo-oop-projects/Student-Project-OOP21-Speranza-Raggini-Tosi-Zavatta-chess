package io;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;
import java.util.Objects;
import static io.JsonUtils.getMapper;
/**
 * 
 *
 */
public class JsonSerializerImpl implements JsonSerializer {
    @Override
    public String serialize(final Object obj) throws JsonProcessingException {
        return getMapper().writeValueAsString(obj);
    }
}
