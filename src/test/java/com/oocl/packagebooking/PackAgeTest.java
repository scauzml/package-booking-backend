package com.oocl.packagebooking;

import com.oocl.packagebooking.entity.PackAge;
import com.oocl.packagebooking.util.LocateDateUtil;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackAgeTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired

    @BeforeEach
    public void beforeEach() {

    }


    @Test
    public void should_return_is_created_when_post_PackAge_to_save() throws Exception{
        //given
        PackAge packAge = new PackAge();
        packAge.setCustomerName("customer1");
        packAge.setPhone("1111");
        packAge.setState("未取件");
        LocalDateTime startTime = LocateDateUtil.getLocalDateTime(new Date());
        packAge.setLoaclDateTime(startTime);
        JSONObject jsonObject = new JSONObject(packAge);
        //when
        //when
        String result=this.mockMvc.perform(post("/packages/addPackage").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        //then
        JSONObject jsonObject1=new JSONObject(result);
        Assertions.assertEquals("customer1",jsonObject.getString("customerName"));


    }



}
