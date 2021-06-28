//package tai.spring;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(SpringController.class)
//public class TestIndexPage {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void testIndexPage() throws Exception {
//		mockMvc
//		.perform(get("/home?name=Hello").characterEncoding("UTF-8"))
//		.andDo(print())
//		.andExpect(status().isOk())
////		.andExpect(view().name("/index.html"))
//		.andExpect(content().string(containsString("Hello")))
//		;
//		
//		mockMvc
//			.perform(get("/index.html"))
//			.andExpect(content().string(containsString("Hello, world")))
//			;
//	}
//}
