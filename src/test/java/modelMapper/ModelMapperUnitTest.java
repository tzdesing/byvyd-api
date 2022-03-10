package modelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.byvyd.api.controller.dto.EventDTO;
import com.byvyd.api.controller.dto.EventCreateDTO;
import java.time.Instant;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperUnitTest {
    /*private ModelMapper mapper;

    @BeforeEach
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Test
    public void whenMapWithExactMatch_thenConvertsToDTO() {
        // when similar source object is provided
        EventDTO eventDTO = new EventDTO();
        EventCreateDTO eventCreateDTO = this.mapper.map(eventDTO, EventCreateDTO.class);

        // then it maps by default
        assertEquals(eventDTO.getIdOrganizador(), eventCreateDTO.getIdOrganizador());
        assertEquals(eventDTO.getIdHomenageado(), eventCreateDTO.getIdHomenageado());
    }*/
}
