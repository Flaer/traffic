package ru.website.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.website.data.TrafficService;
import ru.website.data.model.Visit;
import ru.website.responses.ExternalStatistic;
import ru.website.responses.Statistic;

import static org.junit.Assert.assertEquals;

/**
 * Created by libragimov on 16.03.2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TrafficController.class, secure = false)
public class TrafficControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrafficService trafficService;


    @Test
    public void visitCorrectResponse() throws Exception {

        Statistic mockStatistic = new Statistic(1L, 1L);
        Mockito.doReturn(mockStatistic).when(
                trafficService).calculateDailyStatistic();

        Mockito.doNothing().when(
                trafficService).saveVisit(Mockito.any(Visit.class));

        String exampleVisit = "{\"userId\":\"admin\",\"pageId\":\"about\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/visit")
                .accept(MediaType.APPLICATION_JSON).content(exampleVisit)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals("http://localhost/statistics",
                response.getHeader(HttpHeaders.LOCATION));

        Mockito.verify(trafficService).calculateDailyStatistic();
        Mockito.verify(trafficService).saveVisit(Mockito.any(Visit.class));
    }

    @Test
    public void statisticsCorrectResponse() throws Exception {

        ExternalStatistic mockExternalStatistic = new ExternalStatistic(2L, 14L, 1L);
        Mockito.doReturn(mockExternalStatistic).when(
                trafficService).calculateFullStatistic(Mockito.any(), Mockito.any());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/statistics?start=2018-03-16&end=2018-03-17").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String exampleExtStatistic = "{\"uniqueUsersAmount\":2,\"visitsAmount\":14,\"regularUsersAmount\":1}";

        JSONAssert.assertEquals(exampleExtStatistic, result.getResponse()
                .getContentAsString(), false);

        Mockito.verify(trafficService).calculateFullStatistic(Mockito.any(), Mockito.any());
    }
}
