package bookstore.bookstore;

//import static org.assertj.core.api.Assertions.assertThat;

//import javax.print.attribute.standard.Media;

//import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


//import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import bookstore.bookstore.domain.Book;

@SpringBootTest
@AutoConfigureMockMvc
public class RestTests {
    @Autowired
    private MockMvc mockMvc;

   // @Autowired
//    private ObjectMapper objectMapper;


    // get all books
    @Test
    public void testGetBooksWithoutAuth() throws Exception {
        mockMvc.perform(get("/books"))
        .andExpect(status().isOk());
    }



    //DELETE is working only for ADMIN

    @Test
    @WithMockUser(username= "admin", authorities = { "ADMIN" })
    public void testDeleteBookAdmin() throws Exception {

        mockMvc.perform(delete("/books/1"));
        mockMvc.perform(get("/books/1"))
        .andExpect(result -> {
            String content = result.getResponse().getContentAsString();
            assertEquals("null", content);
        });

    }

    //DELETE is working only for ADMIN //testing USER:

    @Test
    @WithMockUser(username= "user", authorities = { "USER" })
    public void testDeleteBookUser() throws Exception {

        mockMvc.perform(delete("/books/2"));
        mockMvc.perform(get("/books/2"))
        .andExpect(status().isOk())
        .andExpect(result -> {
            String content = result.getResponse().getContentAsString();
            assertNotEquals("[null]", content);
        });

    }



    /*
    //POST is working only for ADMIN

    @Test
    @WithMockUser(username= "admin", authorities = { "ADMIN" })
    public void testPostBookAdmin() throws Exception {
        Book book = new Book("Testien testi", "Sini", 2025, 12345698, 20);

        mockMvc.perform(post("/books")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(book)))
        .andExpect(status().isOk());

    }   

*/



}