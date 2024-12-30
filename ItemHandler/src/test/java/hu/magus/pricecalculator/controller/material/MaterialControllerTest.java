package hu.magus.pricecalculator.controller.material;

import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.service.material.MaterialCategory;
import hu.magus.pricecalculator.service.material.MaterialService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MaterialControllerTest {

    public static final Material WOOD = new Material();
    public static final Material METAL = new Material();
    public static final Material GLASS = new Material();
    public static final Material DIAMOND = new Material();
    @Mock
    private MaterialService service;
    @Mock
    private ConversionService converter;
    @InjectMocks
    private MaterialController underTest;

    @BeforeEach
    void setUp() {
        WOOD.setMaterialCategory(MaterialCategory.I);
        WOOD.setName("wood");
        WOOD.setId(134L);

        METAL.setMaterialCategory(MaterialCategory.II);
        METAL.setName("metal");
        METAL.setId(135L);

        GLASS.setMaterialCategory(MaterialCategory.III);
        GLASS.setName("glass");
        GLASS.setId(136L);

        DIAMOND.setId(137L);
        DIAMOND.setName("diamond");
        DIAMOND.setMaterialCategory(MaterialCategory.MAGIC);
    }

    @Test
    @DisplayName("GetMaterials method returns all existing materials")
    void testGetMaterial_shouldReturnAllMaterials() {
        //GIVEN
        List<Material> expected = List.of(WOOD, METAL, GLASS, DIAMOND);
        when(service.getAllMaterials()).thenReturn(expected);

        //WHEN
        List<Material> actual = underTest.getMaterials();

        //THEN
        assertEquals(expected, actual);
    }

    @Nested
    @DisplayName("getMaterialsForCategory method")
    class getMaterialsForCategoryTest {

        @Test
        @DisplayName("Valid category name returns all materials for that category")
        void getMaterialsForCategory_shouldReturnAllMaterialsForCategory_whenValidCategory() {
            //GIVEN
            List<Material> expected = List.of(WOOD);
            when(service.getAllMaterialsForCategory(MaterialCategory.I)).thenReturn(expected);
            GetMaterialsForCategoryRequest request = new GetMaterialsForCategoryRequest("I");
            when(converter.convert(request, MaterialCategory.class)).thenReturn(MaterialCategory.I);

            //WHEN
            List<Material> actual = underTest.getMaterialsForCategory(request);

            //THEN
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Invalid category name throws NoCategoryFoundException")
        void getMaterialsForCategory_shouldReturnFalse_whenCategoryIsInvalid() {
            //GIVEN

            //WHEN
            GetMaterialsForCategoryRequest request = new GetMaterialsForCategoryRequest("INVALID");
            NoCategoryFoundException expected = new NoCategoryFoundException("No such material category: " + "INVALID");
            when(converter.convert(request, MaterialCategory.class)).thenThrow(expected);

            //WHEN
            NoCategoryFoundException actual = assertThrows(NoCategoryFoundException.class, () -> underTest.getMaterialsForCategory(request));

            //THEN
            assertEquals(expected.getMessage(), actual.getMessage());
        }
    }

    @Nested
    @DisplayName("getMaterialsWithName method")
    class getMaterialsWithNameTest {

        @Test
        @DisplayName("GetMaterials returns all categories containing given string")
        void getMaterials_shouldReturnAllMaterialsContainingString_whenResultsExists() {
            //GIVEN
            List<Material> expected = List.of(WOOD, DIAMOND);
            when(service.getAllMaterialsWithNameContaining("o")).thenReturn(expected);
            GetMaterialsWithNameRequest request = new GetMaterialsWithNameRequest("o");

            //WHEN
            List<Material> actual = underTest.getMaterialsWithName(request);

            //THEN
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("GetMaterials returns no categories of given string is not contained")
        void getMaterials_shouldReturnNoMaterialsContainingString_whenNoResultsExists() {
            //GIVEN
            List<Material> expected = Collections.emptyList();
            when(service.getAllMaterialsWithNameContaining("y")).thenReturn(expected);
            GetMaterialsWithNameRequest request = new GetMaterialsWithNameRequest("y");

            //WHEN
            List<Material> actual = underTest.getMaterialsWithName(request);

            //THEN
            assertEquals(expected, actual);
        }

    }

    @Nested
    @DisplayName("getMaterialsByName method")
    class getMaterialByNameTest {

        @Test
        @DisplayName("GetMaterials returns exact Material when name is exact")
        void getMaterials_shouldReturnSingleMaterial_whenNameIsExact() {
            //GIVEN
            when(service.getMaterial("wood")).thenReturn(WOOD);

            //WHEN
            Material actual = underTest.getMaterialByName("wood");

            //THEN
            assertEquals(WOOD, actual);
        }

        @Test
        @DisplayName("GetMaterials returns exact nothing when name is mismatch")
        void getMaterials_shouldReturnNothing_whenNameIsMismatch() {
            //GIVEN
            when(service.getMaterial("wod")).thenReturn(WOOD);

            //WHEN
            Material actual = underTest.getMaterialByName("wood");

            //THEN
            assertEquals(WOOD, actual);
        }
    }
}