/*package appsuite.service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import appsuite.domain.Item;

@RunWith(SpringRunner.class)
@JsonTest
public class MyJsonTests {

    @Autowired
    private JacksonTester<Item> json;

    //@Test
    public void testSerialize() throws Exception {
        Item details = new Item(10,"Honda", 10);
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(details)).isEqualToJson("expected.json");
        // Or use JSON path based assertions
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.sku");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.sku")
                .isEqualTo("Honda");
    }

    //@Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\":\"10\",\"sku\":\"Ford\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new Item(10,"Ford", 10));
        assertThat(this.json.parseObject(content).getSku()).isEqualTo("Ford");
    }

}*/