package com.shilpi.app.controller;

import com.shilpi.app.controller.PatientController;
import com.shilpi.app.model.Patient;
import com.shilpi.app.service.PatientService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;
    MockMvc mockMvc;
    @Mock
    PatientService patientService;

    PatientControllerTest(){
        MockitoAnnotations.openMocks(this);
        mockMvc=MockMvcBuilders.standaloneSetup(patientController).build();
    }

    @Test
    void testSavePatient() throws Exception{
        Patient patient=new Patient("1", "P1", "ABC Hospital", 30, "M");
        when(patientService.createPatient(any())).thenReturn(patient);

        mockMvc.perform(post("/patient/save").contestType(MediaType.APPLICATION_JSON).content("{\"id\":\"1\",\"name\":\"P1\",\"hospitalName\":\"ABC Hospital\",\"age\":30,\"gender\":\"M\"}")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("P1"));

    }

    @Test
    public void testUpdatePatient() throws Exception {
        Patient patient1 = new Patient("1", "P1", "ABC Hospital", 30, "M");
        when(patientService.updateHname("1", "Updated Hospital")).thenReturn(patient1);
       mockMvc.perform(put("/patient/update?id=1&hospitalName=Updated Hospital")).andExpect(status().isOk()).andExpect(jsonPath("$.hospitalName").value("Updated Hospital"));    }
    @Test
    public void testDeletePatient() throws Exception{
        doNothing().when(patientService).deletePatient("1");
        mockMvc.perform(delete("/patient/delete?id=1")).andExpect(status().isOk());
        verify( patientService, times(1)).deletePatient("1");
    }


}
