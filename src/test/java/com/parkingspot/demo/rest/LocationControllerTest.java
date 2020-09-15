package com.parkingspot.demo.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkingspot.demo.dto.AddressResponse;
import com.parkingspot.demo.dto.Locations;
import com.parkingspot.demo.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LocationController.class)
@ActiveProfiles("test")
class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressResponse addressResponse;

    @MockBean
    private LocationService locationService;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        this.addressResponse = new AddressResponse();
        ObjectMapper mapper = new ObjectMapper();
        String testJson = "{\n" +
                "            \"title\": \"La Vida Cafe\",\n" +
                "            \"resultType\": \"place\",\n" +
                "            \"address\": {\n" +
                "                \"label\": \"La Vida Cafe, Radial Road No 4, Block B, Connaught Place, New Delhi 110001, India\",\n" +
                "                \"countryCode\": \"IND\",\n" +
                "                \"countryName\": \"India\",\n" +
                "                \"stateCode\": \"DL\",\n" +
                "                \"state\": \"Delhi\",\n" +
                "                \"county\": \"New Delhi\",\n" +
                "                \"city\": \"New Delhi\",\n" +
                "                \"district\": \"Connaught Place\",\n" +
                "                \"subdistrict\": \"Block B\",\n" +
                "                \"postalCode\": \"110001\"\n" +
                "            }\n" +
                "        }";
        String testJson2 = "{\n" +
                "            \"title\": \"The Magic Club\",\n" +
                "            \"resultType\": \"place\",\n" +
                "            \"address\": {\n" +
                "                \"label\": \"The Magic Club, Radial Road No 4, Block B, Connaught Place, New Delhi 110001, India\",\n" +
                "                \"countryCode\": \"IND\",\n" +
                "                \"countryName\": \"India\",\n" +
                "                \"stateCode\": \"DL\",\n" +
                "                \"state\": \"Delhi\",\n" +
                "                \"county\": \"New Delhi\",\n" +
                "                \"city\": \"New Delhi\",\n" +
                "                \"district\": \"Connaught Place\",\n" +
                "                \"subdistrict\": \"Block B\",\n" +
                "                \"postalCode\": \"110001\"\n" +
                "            }\n" +
                "        }";
        Locations readValue = mapper.readValue(testJson, Locations.class);
        Locations readValue2 = mapper.readValue(testJson2, Locations.class);
        List<Locations> listLocations = new ArrayList<Locations>();
        listLocations.add(readValue);
        listLocations.add(readValue2);
        addressResponse.setItems(listLocations);
        System.out.println("readValue = " + readValue);
    }

    @Test
    void testReturnLocations()throws Exception{

        Mockito.when(locationService.getResponse("ABC")).thenReturn(addressResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/locations?query=ABC")
                .contentType("application/json"))
                .andExpect(status().isOk());

    }
}