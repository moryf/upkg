package com.njt.upkg.repository;
import com.njt.upkg.domain.Material;
import com.njt.upkg.domain.MaterialType;
import com.njt.upkg.domain.MeasuringUnit;
import com.njt.upkg.repository.MaterialRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MaterialRepositoryTest {

    @Autowired
    private MaterialRepository materialRepository;

    @Test
    public void testFindAllByType() {
        Material material1 = new Material();
        material1.setName("Ploca");
        material1.setType(MaterialType.Sirov);
        material1.setInDepo(100);
        material1.setWeight(10.5f);
        material1.setArea(2.5f);
        material1.setZinked(false);
        material1.setPainted(true);
        material1.setMeasuringUnit(MeasuringUnit.Metar);
        material1.setPrice(150.0f);

        Material material2 = new Material();
        material2.setName("Bubreg");
        material2.setType(MaterialType.Bubreg);
        material2.setInDepo(50);
        material2.setWeight(5.0f);
        material2.setArea(1.0f);
        material2.setZinked(false);
        material2.setPainted(false);
        material2.setMeasuringUnit(MeasuringUnit.Komad);
        material2.setPrice(50.0f);

        materialRepository.saveAll(List.of(material1, material2));

        List<Material> siroviMaterials = materialRepository.findAllByType(MaterialType.Sirov);
        List<Material> bubregMaterials = materialRepository.findAllByType(MaterialType.Bubreg);

        assertEquals(1, siroviMaterials.size());
        assertEquals(1, bubregMaterials.size());

        Material returnSirovMaterial = siroviMaterials.get(0);
        Material returnBubregMaterial = bubregMaterials.get(0);

        assertEquals(material1.getName(), returnSirovMaterial.getName());
        assertEquals(material1.getType(), returnSirovMaterial.getType());
        assertEquals(material1.getInDepo(), returnSirovMaterial.getInDepo());
        assertEquals(material1.getWeight(), returnSirovMaterial.getWeight());
        assertEquals(material1.getArea(), returnSirovMaterial.getArea());
        assertEquals(material1.isZinked(), returnSirovMaterial.isZinked());
        assertEquals(material1.isPainted(), returnSirovMaterial.isPainted());
        assertEquals(material1.getMeasuringUnit(), returnSirovMaterial.getMeasuringUnit());
        assertEquals(material1.getPrice(), returnSirovMaterial.getPrice());

        assertEquals(material2.getName(), returnBubregMaterial.getName());
        assertEquals(material2.getType(), returnBubregMaterial.getType());
        assertEquals(material2.getInDepo(), returnBubregMaterial.getInDepo());
        assertEquals(material2.getWeight(), returnBubregMaterial.getWeight());
        assertEquals(material2.getArea(), returnBubregMaterial.getArea());
        assertEquals(material2.isZinked(), returnBubregMaterial.isZinked());
        assertEquals(material2.isPainted(), returnBubregMaterial.isPainted());
        assertEquals(material2.getMeasuringUnit(), returnBubregMaterial.getMeasuringUnit());
        assertEquals(material2.getPrice(), returnBubregMaterial.getPrice());
    }
}

