package br.com.ada;

import br.com.ada.application.CostumerController;
import br.com.ada.application.CostumerService;
import br.com.ada.domain.Costumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest
public class CostumerControllerTest {

    @Autowired
    private CostumerController costumerController;
    @MockBean
    private CostumerService costumerService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(costumerController).build();
    }

    @Test
    public void deve_adicionar_um_costumer() throws Exception{
        Costumer costumer = new Costumer();
        costumer.setCpf("123456789");
        costumer.setName("Audrey");
        costumer.setAge(23);

        String json = new ObjectMapper().writeValueAsString(costumer);

        var requestBuilder = MockMvcRequestBuilders.post("/costumers")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON);

        when(this.costumerService.save(costumer)).thenReturn(costumer);

        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void deve_retornar_o_costumer_por_cpf() throws Exception{
        Costumer costumer = new Costumer();
        costumer.setCpf("123456789");
        costumer.setName("Audrey");
        costumer.setAge(23);

        Optional<Costumer> optionalCostumer = Optional.of(costumer);
        var requestBuilder = MockMvcRequestBuilders.get("/costumers?cpf=123456789");
        when(this.costumerService.getByCpf("123456789")).thenReturn(optionalCostumer);

        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("123456789"));

    }

}
