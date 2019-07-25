package com.oocl.packagebooking;

import com.oocl.packagebooking.dao.BookPickGoodResponsity;
import com.oocl.packagebooking.entity.BookPickGood;
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
public class GetFoodTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    BookPickGoodResponsity bookPickGoodResponsity;
    @BeforeEach
    public void beforeEach() {
        bookPickGoodResponsity.deleteAll();
    }

    @Test
    public void should_return_is_ok_when_post_todolistEntity_to_save() throws Exception{
        //given
        BookPickGood bookPickGood = new BookPickGood();
        LocalDateTime startTime = LocateDateUtil.getLocalDateTime(new Date());
         bookPickGood.setGoodId("11");
         bookPickGood.setLoaclDateTime(startTime);

        JSONObject jsonObject = new JSONObject(bookPickGood);

        //when
        //when
        String result=this.mockMvc.perform(post("/Goods/addBookPickGood").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        //then
        JSONObject jsonObject1=new JSONObject(result);
        Assertions.assertEquals("11",jsonObject.getString("goodId"));


    }
}
