package com.kapx.testdriven.service;

import com.kapx.testdriven.dao.EmployeeDao;
import com.kapx.testdriven.dao.EmployeeNotFoundException;
import com.kapx.testdriven.dto.EmployeeDto;
import com.kapx.testdriven.dto.EmployeeDtoBuilder;
import com.kapx.testdriven.entity.EmployeeEntity;
import com.kapx.testdriven.entity.EmployeeEntityBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    private static final Long ID = 1L;

    @Mock
    private EmployeeDao mockedEmployeeDao;

    private EmployeeService objUnderTest;

    @BeforeEach
    void init() {
        objUnderTest = new EmployeeServiceImpl(mockedEmployeeDao);
    }

    @AfterEach
    void tearDown() {
        objUnderTest = null;
    }

    @Test
    public void save_withValidEmployeeDto_persistsEmployeeEntity() throws Exception {
        final EmployeeEntity entity = buildEmployeeEntity();
        when(mockedEmployeeDao.save(any(EmployeeEntity.class))).thenReturn(entity);

        objUnderTest.save(buildEmployeeDto());

        verify(mockedEmployeeDao, times(1)).save(any(EmployeeEntity.class));
    }

    @Test
    public void findById_withInvalidId_throwsEmployeeNotFoundException() throws Exception {
        when(mockedEmployeeDao.findById(anyLong())).thenThrow(new EmployeeNotFoundException(ID));
        Throwable exception = assertThrows(EmployeeNotFoundException.class, () -> {
            objUnderTest.findById(ID);
        });
        assertEquals(exception.getMessage(), "Employee with ID " + ID + " not found.");
    }

    @Test
    public void findById_withValidId_returnEmployeeEntity() throws Exception {
        when(mockedEmployeeDao.findById(anyLong())).thenAnswer((invocationOnMock) -> buildEmployeeEntity());

        final EmployeeDto dto = objUnderTest.findById(ID);
        assertNotNull(dto, "should not be null");
        verify(mockedEmployeeDao, times(1)).findById(ID);

        assertAll("dto",
                () -> assertEquals("De", dto.getFirstName()),
                () -> assertEquals("Kapx", dto.getLastName()),
                () -> assertEquals("Engineering", dto.getDept())
        );
    }

    @Test
    public void findAll_returnListWithOneDto() throws Exception {
        when((mockedEmployeeDao.findAll())).thenAnswer((invocationOnMock) -> Arrays.asList(buildEmployeeEntity()));

        final List<EmployeeDto> dtos = objUnderTest.findAll();
        assertEquals(1, dtos.size());

        final EmployeeDto dto = dtos.iterator().next();
        assertAll("dto",
                () -> assertEquals("De", dto.getFirstName()),
                () -> assertEquals("Kapx", dto.getLastName()),
                () -> assertEquals("Engineering", dto.getDept())
        );
    }

    @Test
    public void delete_withInvalidId_throwsEmployeeNotFoundException() throws Exception {
        doThrow(new EmployeeNotFoundException(ID)).when(mockedEmployeeDao).delete(anyLong());

        Throwable exception = assertThrows(EmployeeNotFoundException.class, () -> {
            objUnderTest.delete(ID);
        });
        assertEquals(exception.getMessage(), "Employee with ID " + ID + " not found.");
    }

    @Test
    public void delete_withValidId_deleteEmployee() throws Exception {
        doNothing().when(mockedEmployeeDao).delete(ID);

        objUnderTest.delete(ID);

        verify(mockedEmployeeDao, times(1)).delete(ID);
    }

    private EmployeeEntity buildEmployeeEntity() {
        return EmployeeEntityBuilder.builder()
                .id(ID)
                .firstName("De")
                .lastName("Kapx")
                .dept("Engineering")
                .build();
    }

    private EmployeeDto buildEmployeeDto() {
        return EmployeeDtoBuilder.builder()
                .firstName("De")
                .lastName("Kapx")
                .dept("Engineering")
                .build();
    }
}

