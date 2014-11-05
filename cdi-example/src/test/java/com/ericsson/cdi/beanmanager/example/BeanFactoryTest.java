package com.ericsson.cdi.beanmanager.example;

import static org.junit.Assert.*;

import org.junit.*;

public class BeanFactoryTest {
    private BeanFactory beanFactory;

    @Before
    public void setUp() throws Exception {
        beanFactory = BeanFactory.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        beanFactory = null;
    }

    @Test
    public void testGetBeanInstanceByName() {
        XmlFileWriter fileWriter = beanFactory.getBeanInstanceByName("xmlFileWriter");
        assertNotNull(fileWriter);
        assertTrue(fileWriter instanceof XmlFileWriter);
        fileWriter.write("sample text");
    }

}
