package com.kapx.testdriven.service;

import com.kapx.testdriven.dao.EmployeeDao;
import com.kapx.testdriven.dao.EmployeeNotFoundException;
import com.kapx.testdriven.dto.EmployeeDto;
import com.kapx.testdriven.entity.EmployeeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
    private static final Long ID = 1L;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private EmployeeServiceImpl objUnderTest;

    @Mock
    private EmployeeDao mockedEmployeeDao;

    @Before
    public void setup() throws Exception {
        objUnderTest = new EmployeeServiceImpl(mockedEmployeeDao);
    }

    @After
    public void teardown() throws Exception {
    }

    @Test
    public void constructor_initialization() throws Exception {
        assertSame(mockedEmployeeDao, objUnderTest.getEmployeeDao());
    }

    @Test
    public void save_withValidEmployeeDto_persistsEmployeeEntity() throws Exception {
        final EmployeeEntity entity = buildEmployeeEntity();
        when(mockedEmployeeDao.save(Matchers.<EmployeeEntity>any())).thenReturn(entity);

        objUnderTest.save(buildEmployeeDto());

        verify(mockedEmployeeDao, times(1)).save(Matchers.<EmployeeEntity>any());
    }

    @Test
    public void findById_withInvalidId_throwsEmployeeNotFoundException() throws Exception {
        when(mockedEmployeeDao.findById(anyLong())).thenThrow(new EmployeeNotFoundException(ID));

        thrown.expect(EmployeeNotFoundException.class);
        thrown.expectMessage("Employee with ID " + ID + " not found.");

        objUnderTest.findById(ID);
    }

    @Test
    public void findById_withValidId_returnEmployeeEntity() throws Exception {
        when(mockedEmployeeDao.findById(anyLong())).thenAnswer((invocationOnMock) -> buildEmployeeEntity());

        final EmployeeDto dto = objUnderTest.findById(ID);

        assertThat(dto, is(notNullValue()));
        verify(mockedEmployeeDao, times(1)).findById(ID);

        // perform common asserts in a specific assert method, no need to perform repetitive asserts
        assertEmployeeDto(dto);
    }

    @Test
    public void findAll_returnListWithOneDto() throws Exception {
        when((mockedEmployeeDao.findAll())).thenAnswer((invocationOnMock) -> Arrays.asList(buildEmployeeEntity()));

        final List<EmployeeDto> dtos = objUnderTest.findAll();
        assertThat(dtos, hasSize(1));

        final EmployeeDto dto = dtos.iterator().next();
        // perform common asserts in a specific assert method, no need to perform repetitive asserts
        assertEmployeeDto(dto);
    }

    @Test
    public void delete_withInvalidId_throwsEmployeeNotFoundException() throws Exception {
        doThrow(new EmployeeNotFoundException(ID)).when(mockedEmployeeDao).delete(anyLong());

        thrown.expect(EmployeeNotFoundException.class);
        thrown.expectMessage("Employee with ID " + ID + " not found.");

        objUnderTest.delete(ID);
    }

    @Test
    public void delete_withValidId_deleteEmployee() throws Exception {
        doNothing().when(mockedEmployeeDao).delete(ID);

        objUnderTest.delete(ID);

        verify(mockedEmployeeDao, times(1)).delete(ID);
    }


    // make use of builder pattern for constructing objects...
    private EmployeeEntity buildEmployeeEntity() {
        return EmployeeEntity.builder()
                .id(ID)
                .firstName("De")
                .lastName("Kapx")
                .dept("Engineering")
                .build();
    }

    // make use of builder pattern for constructing objects...
    private EmployeeDto buildEmployeeDto() {
        return EmployeeDto.builder()
                .firstName("De")
                .lastName("Kapx")
                .dept("Engineering")
                .build();
    }

    // for common assert operations, use a specific assert method...
    private void assertEmployeeDto(final EmployeeDto dto) {
        assertThat(dto.getFirstName(), is(equalTo("De")));
        assertThat(dto.getLastName(), is(equalTo("Kapx")));
        assertThat(dto.getDept(), is(equalTo("Engineering")));
    }
}
