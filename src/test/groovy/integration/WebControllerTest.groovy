


@AutoConfigureMockMvc
@WebMvcTest
class WebControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(get("/hello"))
          .andExpect(status().isOk())
          .andReturn()
          .response
          .contentAsString == "Hello world!"
    }
}