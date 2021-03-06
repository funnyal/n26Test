/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Statistic;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class N26ControllerTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    ObjectMapper objectMapper;
    
    @Test
    public void postTransactionShouldReturnCreated() throws Exception {
//
    	Statistic stat = new Statistic(12.3, System.currentTimeMillis());
        this.mockMvc.perform(post("/transactions")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(stat)))
                .andExpect(status().isCreated());
    }
    
//    @Test
//    public void postTransactionShouldReturnNoContent() throws Exception {
////
//    	Statistic stat = new Statistic(12.3, System.currentTimeMillis()-36000);
//        this.mockMvc.perform(post("/transactions")
//        		.contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(stat)))
//                .andExpect(status().isNoContent());
//    }
//    
//    @Test
//    public void shouldReturnStatistics() throws Exception {
////
//    	Statistic stat = new Statistic(12.3, System.currentTimeMillis());
//        this.mockMvc.perform(post("/transactions")
//        		.contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(stat)))
//                .andExpect(status().isCreated());
//    }
    

}
