package local.knowledge.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import local.koltun.config.ApplicationConfig;
import local.koltun.domain.Task;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.apache.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class RestControllerTest {
    private Logger logger = Logger.getLogger(RestControllerTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).dispatchOptions(true).build();
    }

    @Test
    public void thatAllTasksIsAbleToShow() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/tasks/").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        logger.info(result.getResponse().getContentAsString());
    }

    @Test
    public void thatTaskIsAbleToShow() throws Exception {
        String path = "/rest/tasks/1";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();

        logger.info(result.getResponse().getContentAsString());
    }

    @Test
    public void thatTaskIsAdding() throws Exception {
        for (int i = 0; i < 4; i++) {
            Task task = new Task();
            task.setTitle("TestTitle" + i);
            task.setDescription("TestDescription" + i);
            task.setPriority("TestPriority" + i);
            task.setStatus("TestStatus" + i);
            task.setArchived(false);

            String taskJson = new ObjectMapper().writeValueAsString(task);

            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/rest/tasks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(taskJson);

            MvcResult result = mockMvc
                    .perform(requestBuilder)
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8"))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();

            logger.info(result.getResponse().getContentAsString());
        }
    }

    @Test
    public void thatTaskCanBeDeleted() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/rest/tasks/1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        logger.info(result.getResponse().getContentAsString());
    }
}
