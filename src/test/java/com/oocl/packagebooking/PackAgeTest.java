package com.oocl.packagebooking;

import com.oocl.packagebooking.dao.PackAgeResponsity;
import com.oocl.packagebooking.entity.PackAge;
import com.oocl.packagebooking.util.LocateDateUtil;
import org.json.JSONArray;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackAgeTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    PackAgeResponsity packAgeResponsity;

    @BeforeEach
    public void beforeEach() {
     packAgeResponsity.deleteAll();
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

    @Test
    public void should_return_is_all_packageMessage_when_get_PackAge() throws Exception{
        //given
        PackAge packAge = new PackAge();
        packAge.setCustomerName("customer1");
        packAge.setPhone("1111");
        packAge.setState("未取件");
        LocalDateTime startTime = LocateDateUtil.getLocalDateTime(new Date());
        packAge.setLoaclDateTime(startTime);
        PackAge packAge1 = new PackAge();
        packAge1.setCustomerName("customer2");
        packAge1.setPhone("1111");
        packAge1.setState("未取件");
        LocalDateTime startTime1 = LocateDateUtil.getLocalDateTime(new Date());
        packAge.setLoaclDateTime(startTime1);
        packAgeResponsity.save(packAge);
        packAgeResponsity.save(packAge1);

        //when
        String result=this.mockMvc.perform(get("/packages")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //then
        JSONArray jsonArray=new JSONArray(result);

        Assertions.assertEquals("customer1",jsonArray.getJSONObject(0).getString("customerName"));
        Assertions.assertEquals("customer2",jsonArray.getJSONObject(1).getString("customerName"));


    }

    @Test
    public void should_return_is_right_state_package_is_get_package_by_state_when_get_PackAge() throws Exception{
        //given
        PackAge packAge = new PackAge();
        packAge.setCustomerName("customer1");
        packAge.setPhone("1111");
        packAge.setState("已预约");
        LocalDateTime startTime = LocateDateUtil.getLocalDateTime(new Date());
        packAge.setLoaclDateTime(startTime);
        PackAge packAge1 = new PackAge();
        packAge1.setCustomerName("customer2");
        packAge1.setPhone("1111");
        packAge1.setState("未取件");
        LocalDateTime startTime1 = LocateDateUtil.getLocalDateTime(new Date());
        packAge.setLoaclDateTime(startTime1);
        packAgeResponsity.save(packAge);
        packAgeResponsity.save(packAge1);

        //when
        String result=this.mockMvc.perform(get("/packages").param("state","已预约")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //then
        JSONArray jsonArray=new JSONArray(result);

        Assertions.assertEquals(1,jsonArray.length());
        Assertions.assertEquals("customer1",jsonArray.getJSONObject(0).getString("customerName"));

    }


    @Test
    public void should_return_is_is_ok_is_put_to_change_package_state() throws Exception{
        //given
        PackAge packAge = new PackAge();
        packAge.setCustomerName("customer1");
        packAge.setPhone("1111");
        packAge.setState("已预约");
        LocalDateTime startTime = LocateDateUtil.getLocalDateTime(new Date());
        packAge.setLoaclDateTime(startTime);
        PackAge packAge1 = packAgeResponsity.save(packAge);

        packAge1.setState("已取件");
        JSONObject jsonObject = new JSONObject(packAge1);
        //when
        String result=this.mockMvc.perform(put("/packages/"+packAge1.getId()).content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //then

        JSONObject jsonObject1 = new JSONObject(result);
        Assertions.assertEquals("已取件",jsonObject1.getString("state"));

    }

}
