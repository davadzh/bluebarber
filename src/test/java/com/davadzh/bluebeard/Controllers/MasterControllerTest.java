package com.davadzh.bluebeard.Controllers;

import com.davadzh.bluebeard.BLL.Services.MasterService.IMasterService;
import com.davadzh.bluebeard.DAL.Master.Master;
import com.davadzh.bluebeard.DTO.MasterDtos.AddMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.GetMasterByIdDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MasterControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private IMasterService masterService;

    @Autowired
    public void setMasterServices(IMasterService masterService){
        this.masterService = masterService;
    }

    @Test
    public void createMaster() {
        var newMaster = new AddMasterDto();
        newMaster.fullName = "Степанов Владимир Игоревич";
        newMaster.age = 22;
        newMaster.position = "Младший барбер";

        Master master = new Master(newMaster);
        try {
            this.mvc.perform(MockMvcRequestBuilders.post("http://localhost:5000/api/cars")
                    .content(JSONToStr(master))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getMasterById() throws Exception {
        var getMasterByIdDto = new GetMasterByIdDto();
        getMasterByIdDto.setMasterId(28L);

        this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:5000/api/admin/master/getMasters"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError())
                .andExpect(mvcResult -> {
                    String body = mvcResult.getResponse().getContentAsString();
                    JSONArray arr = new JSONArray(body); // переделываем в JSON
                    assertEquals(masterService.getMasters().size(), arr.length()); // сверяем длину массива через репозиторий и длину пришедшешго массива
                })
                .andReturn();
    }


    @Test
    public void addMaster() {
        var newMaster = new AddMasterDto();
        newMaster.fullName = "Степанов Иван Игоревич";
        newMaster.age = 22;
        newMaster.position = "Младший барбер";

        try {
            this.mvc.perform(MockMvcRequestBuilders.post("http://localhost:5000/api/master/addMaster")
                    .content(JSONToStr(newMaster))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String JSONToStr(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonToString = mapper.writeValueAsString(object);
            return jsonToString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}