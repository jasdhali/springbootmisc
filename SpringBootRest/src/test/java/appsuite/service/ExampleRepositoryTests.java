package appsuite.service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import appsuite.data.repository.ItemRepository;
import appsuite.domain.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExampleRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ItemRepository repository;

    @Test
    public void testExample() throws Exception {
        this.entityManager.persist(new Item(100,"sboot", 1234));
        Item user = this.repository.findOne(100l);
        assertThat(user.getSku()).isEqualTo("sboot");
        assertThat(user.getReorderQuantity()).isEqualTo(1234);
    }

}